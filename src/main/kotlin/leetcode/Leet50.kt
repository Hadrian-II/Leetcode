package leetcode

import kotlin.math.abs

fun main() {
    println(Solution50().myPow(2.0, 10))
    println(Solution50().myPow(2.1, 3))
    println(Solution50().myPow(2.0, -2))
    println(Solution50().myPow(1.0, Int.MIN_VALUE))
    val blorp = Solution50()
    println(blorp.myPow(0.00001, Int.MAX_VALUE))
    val blah = 1
}

class Solution50 {
    val memo = HashMap<Int, Double>()

    fun myPow(x: Double, n: Int): Double {
        return calcPow(x, n)
    }

    fun calcPow(x: Double, n: Int): Double {
        return memo.getOrPut(n) {
            when (n) {
                1 -> x
                0 -> 1.0
                -1 -> 1 / x
                else -> {
                    var half = 0
                    if (n > 0) {
                        half = n.takeHighestOneBit()
                        if (half == n) {
                            half = half.shr(1)
                        }
                    } else {
                        half = -1
                        var double = half.shl(1)

                        while (double < 0 && double > n) {
                            half = double
                            double = half.shl(1)
                        }
                    }
                    val first = calcPow(x, half)
                    if (first == 0.0) {
                        0.0
                    } else {
                        first * calcPow(x, n - half)
                    }
                }
            }
        }
    }
}