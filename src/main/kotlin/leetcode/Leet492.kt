package leetcode

import helpers.printIntArray
import kotlin.math.sqrt

fun main() {
    printIntArray(constructRectangle(4))
    printIntArray(constructRectangle(37))
    printIntArray(constructRectangle(122122))
    printIntArray(constructRectangle(6))
    printIntArray(constructRectangle(10000000))
}

fun constructRectangle(area: Int): IntArray {
    var sqrt = sqrt(area.toDouble()).toInt()

    while (area % sqrt != 0) {
        sqrt--
    }

    return intArrayOf(area / sqrt, sqrt)
}