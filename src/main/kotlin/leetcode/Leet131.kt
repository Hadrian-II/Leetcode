package leetcode

import kotlin.math.min

fun main() {
    Solution131().partition("aab").forEach { println(it)}
    println('-')
    Solution131().partition("abbab").forEach { println(it)}
    println('-')
    Solution131().partition("cbbbcc").forEach { println(it)}
    println('-')
    Solution131().partition("racecar").forEach { println(it)}
    println(Solution131().partition("ababbbabbaba").count())
}

class Solution131 {
    val palindromes = mutableMapOf<Int, MutableList<Int>>()
    lateinit var s: String
    val memo = mutableMapOf<Triple<Int, Int, Int>, List<List<String>>>()

    fun partition(s: String): List<List<String>> {
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

        return createSolutions(0, s.length, Int.MAX_VALUE)
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

    private fun createSolutions(from: Int, to: Int, maxSize: Int): List<List<String>> {
        return memo.getOrPut(Triple(from, to, maxSize)) {
            val max = min(to - from, maxSize)
            val results = mutableListOf(s.substring(from, to).map { it.toString() })
            if (max == 1) {
                results
            }

            for (size in palindromes.keys) {
                if (size <= max) {
                    for (start in palindromes[size]!!) {
                        if (start >= from && start + size <= to) {
                            val current = s.substring(start, start + size)
                            val withBefores = if (start == from) {
                                listOf(listOf(current))
                            } else if (start - 1 == from || size - 1 == 1) {
                                listOf(s.substring(from, start).mapTo(mutableListOf()) { it.toString() }
                                                               .apply { add(current) })
                            } else {
                                createSolutions(from, start, size - 1).map { it + listOf(current) }
                            }
                            if (start + size == to) {
                                results.addAll(withBefores)
                            } else if (start + size + 1 == to) {
                                results.addAll(withBefores.map { it + listOf(s[to - 1].toString()) })
                            } else {
                                results.addAll(
                                    createSolutions(start + size, to,size).flatMap {
                                        after -> withBefores.map { before -> before + after } })
                            }
                        }
                    }
                }
            }
            results
        }
    }
}