package leetcode

import kotlin.math.min

fun main() {
    println(trailingZeroes(3))
    println(trailingZeroes(5))
    println(trailingZeroes(0))
}

fun trailingZeroes(n: Int): Int {
    var fives = 0
    var current = 5
    while (current <= n) {
        fives += n / current
        current *= 5
    }

    return fives
}