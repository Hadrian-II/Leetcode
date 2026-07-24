package leetcode

import kotlin.math.max

fun main() {
    println(Solution343().integerBreak(2))
    println(Solution343().integerBreak(10))
    println(Solution343().integerBreak(11))
    println(Solution343().integerBreak(6))
    println(Solution343().integerBreak(3))
}

class Solution343 {
    lateinit var memo: IntArray

    fun integerBreak(n: Int): Int {
        if (n == 2) {
            return 1
        }
        memo = IntArray(n + 1)
        memo[1] = 1
        memo[2] = 2
        return iBreak(n, true)
    }

    private fun iBreak(n: Int, first: Boolean): Int {
        if (memo[n] == 0) {
            var max = if (first) 0 else n

            for (i in 1..<n) {
                max = max(max, (n - i) * iBreak(i, false))
            }

            memo[n] = max
        }

        return memo[n]
    }
}