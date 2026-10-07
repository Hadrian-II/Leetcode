package leetcode

import kotlin.math.min

fun main() {
    println(findPoisonedDuration(intArrayOf(1,4), 2))
    println(findPoisonedDuration(intArrayOf(1,2), 2))
}

fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var totalDuration = 0
    for (i in 0 until timeSeries.lastIndex) {
        totalDuration += min(timeSeries[i + 1] - timeSeries[i], duration)
    }
    return totalDuration + duration
}