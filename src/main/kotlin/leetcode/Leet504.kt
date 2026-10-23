package leetcode

import kotlin.math.abs

fun main() {
    println(convertToBase7(100))
    println(convertToBase7(-7))
}

fun convertToBase7(num: Int): String {
    if (num == 0) {
        return "0"
    }

    var current = abs(num)
    val result = StringBuilder()

    while (current > 0) {
        result.append(current % 7)
        current /= 7
    }

    if (num < 0) {
        result.append('-')
    }

    return result.reverse().toString()
}