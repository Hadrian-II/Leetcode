package leetcode

import kotlin.math.max

fun main() {
    println(maxDistance(intArrayOf(1,1,1,6,1,1,1)))
    println(maxDistance(intArrayOf(1,8,3,8,3)))
    println(maxDistance(intArrayOf(0,1)))
    println(maxDistance(intArrayOf(6,6,6,6,6,6,6,6,6,19,19,6,6)))
}

fun maxDistance(colors: IntArray): Int {
    for (i in colors.indices) {
        if (colors[i] != colors.last() || colors[colors.lastIndex - i] != colors.first()) {
            return colors.lastIndex - i
        }
    }
    return -1
}