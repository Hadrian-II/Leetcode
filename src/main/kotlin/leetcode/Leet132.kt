package leetcode

import kotlin.math.min

fun main() {
    println(Solution132().minCut("bb"))
    println(Solution132().minCut("aab"))
    println(Solution132().minCut("a"))
    println(Solution132().minCut("ab"))
    println(Solution132().minCut("cdd"))
    println(Solution132().minCut("abcd"))
    println(Solution132().minCut("cabababcbc"))
    println(Solution132().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
    println(Solution132().minCut("ccaacabacb"))
    println(Solution132().minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"))
}

class Solution132 {
    lateinit var isPalindrome: Array<BooleanArray>
    lateinit var word: String

    fun minCut(s: String): Int {
        isPalindrome = Array(s.length) { BooleanArray(s.length) }
        word = s

        for (i in word.indices) {
            checkPalindrome(i, i)
            checkPalindrome(i, i + 1)
        }

        val dp = IntArray(word.length)

        for (i in dp.indices) {
            if (isPalindrome[0][i]) {
                dp[i] = 0
            } else {
                dp[i] = dp[i - 1] + 1
                for (j in 1..<i) {
                    if (isPalindrome[j][i]) {
                        dp[i] = min(dp[i], dp[j - 1] + 1)
                    }
                }
            }
        }

        return dp.last()
    }

    fun checkPalindrome(from: Int, to: Int) {
        while (from >= 0 && to < word.length && word[from] == word[to]) {
            isPalindrome[from][to] = true
            checkPalindrome(from - 1, to + 1)
        }
    }
}

class Solution132ShittyButSelfmade {
    val palindromes = mutableMapOf<Int, MutableList<Int>>()
    lateinit var s: String
    val memo = mutableMapOf<Pair<Int, Int>, Int>()

    fun minCut(s: String): Int {
        this.s = s
        palindromes[2] = mutableListOf()
        palindromes[3] = mutableListOf()

        for (i in 0..<s.lastIndex) {
            if (s[i] == s[i + 1]) {
                palindromes[2]!!.add(i)
            }

            if (i > 0 && s[i - 1] == s[i + 1]) {
                palindromes[3]!!.add(i - 1)
            }
        }

        var check = 2
        var found = true
        while (found) {
            found = false
            if (check in palindromes) {
                checkForBiggerPalindrome(check)
                found = true
            }
            if (check + 1 in palindromes) {
                checkForBiggerPalindrome(check + 1)
                found = true
            }
            check += 2
        }

        return getMinCut(0, s.length)
    }

    private fun checkForBiggerPalindrome(check: Int) {
        for (start in palindromes[check]!!) {
            if (start > 0 && start + check <= s.lastIndex && s[start - 1] == s[start + check]) {
                if (check + 2 !in palindromes) {
                    palindromes[check + 2] = mutableListOf()
                }
                palindromes[check + 2]!!.add(start - 1)
            }
        }
    }

    private fun getMinCut(from: Int, to: Int): Int {
        return memo.getOrPut(Pair(from, to)) {
            calculateMinCut(from, to)
        }
    }

    private fun calculateMinCut(from: Int, to: Int): Int {
        val max = to - from
        var result = max - 1
        if (max <= 1) {
            return 0
        }

        for (size in palindromes.keys.reversed()) {
            if (size <= max) {
                for (start in palindromes[size]!!) {
                    if (start >= from && start + size <= to) {
                        result = if (start == from) {
                            if (start + size == to) {
                                return 0
                            } else {
                                min(result, 1 + getMinCut(start + size, to))
                            }
                        } else {
                            if (start + size == to) {
                                min(result, 1 + getMinCut(from, start))
                            } else {
                                min(result, 2 + getMinCut(from, start) + getMinCut(start + size, to))
                            }
                        }
                    }
                }
            }
            if (max > 2 && result <= 1) {
                break
            }
        }
        return result
    }
}