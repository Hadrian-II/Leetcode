package leetcode

import kotlin.math.max

fun main() {
    println(countCommas(1002))
    println(countCommas(998))
}

fun countCommas(n: Int): Int {
    return max(n - 999, 0)
}