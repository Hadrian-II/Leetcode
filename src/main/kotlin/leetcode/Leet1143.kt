package leetcode

import kotlin.math.max

fun main() {
    println(Solution1143().longestCommonSubsequence("abcde", "ace"))
    println(Solution1143().longestCommonSubsequence("abc", "abc"))
    println(Solution1143().longestCommonSubsequence("abc", "def"))
}

class Solution1143 {
    lateinit var t1: String
    lateinit var t2: String
    val memo = HashMap<Pair<Int, Int>, Int>()

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        t1 = text1.filter { it in text2 }
        t2 = text2.filter { it in text1 }
        if (t1.isEmpty() || t2.isEmpty()) {
            return 0
        }
        return lcs(t1.length - 1, t2.length - 1)
    }

    fun lcs(i: Int, j: Int): Int {
        return memo.getOrPut(Pair(i, j)) {
            if (t1[i] == t2[j]) {
                if (i == 0 || j == 0) {
                    1
                } else {
                    lcs(i - 1, j - 1) + 1
                }
            } else {
                max(if(i > 0) lcs(i - 1, j) else 0, if(j > 0) lcs(i, j - 1) else 0)
            }
        }
    }
}