package leetcode

import kotlin.math.min

fun main() {
    println(Solution397().integerReplacement(8))
    println(Solution397().integerReplacement(7))
    println(Solution397().integerReplacement(4))
    println(Solution397().integerReplacement(2147483647))
}

class Solution397 {
    val memo = mutableMapOf<Long, Int>()

    fun integerReplacement(n: Int): Int {
        return process(n.toLong())
    }

    private fun process(n: Long): Int {
        return memo.getOrPut(n) {
            if (n == 1L) {
                0
            } else if (n % 2 == 0L) {
                1 + process(n / 2)
            } else {
                1 + min(process(n + 1), process(n - 1))
            }
        }
    }
}