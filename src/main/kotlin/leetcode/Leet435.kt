package leetcode

import helpers.readArrayOfArrays
import kotlin.math.min

fun main() {
    println(eraseOverlapIntervals(readArrayOfArrays("[[1,2],[2,3],[3,4],[1,3]]")))
    println(eraseOverlapIntervals(readArrayOfArrays("[[1,2],[1,2],[1,2]]")))
    println(eraseOverlapIntervals(readArrayOfArrays("[[1,2],[2,3]]")))
}

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }
    var limit = Int.MIN_VALUE
    var count = 0
    for (i in intervals.indices) {
        if (intervals[i][0] >= limit) {
            count++
            limit = intervals[i][1]
        }
    }
    return intervals.size - count
}