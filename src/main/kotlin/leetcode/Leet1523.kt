package leetcode

import kotlin.math.max

fun main() {
    println(countOdds(3,7))   // 3
    println(countOdds(4,8))   // 2
    println(countOdds(8, 10)) // 1
    println(countOdds(9, 11)) // 2
    println(countOdds(8, 11)) // 2
    println(countOdds(9, 12)) // 2
}

fun countOdds(low: Int, high: Int): Int {
    return (high - low) / 2 + max(low % 2, high % 2)
}