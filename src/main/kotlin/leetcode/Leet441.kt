package leetcode

import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    println(arrangeCoins(1))
    println(arrangeCoins(2))
    println(arrangeCoins(3))
    println(arrangeCoins(4))
    println(arrangeCoins(5))
    println(arrangeCoins(6))
    println(arrangeCoins(8))
}

fun arrangeCoins(n: Int): Int {
    var start = 0L
    var end = 100000L
    var solution = 0L
    while (start <= end) {
        val mid = start + (end - start) / 2L
        val calc = (mid * (mid - 1)) / 2
        if (calc <= n) {
            solution = max(solution, mid)
            start = mid + 1
        } else {
            end = mid -1
        }
    }
    return (solution - 1).toInt()
}