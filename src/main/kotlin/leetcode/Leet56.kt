package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays
import kotlin.math.max

fun main() {
    merge(readArrayOfArrays("[[1,3],[2,6],[8,10],[15,18]]")).forEach { printIntArray(it) }
    merge(readArrayOfArrays("[[1,4],[4,5]]")).forEach { printIntArray(it) }
    merge(readArrayOfArrays("[[4,7],[1,4]]")).forEach { printIntArray(it) }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val results = mutableListOf<IntArray>()
    var start = intervals[0][0]
    var end = intervals[0][1]
    var i = 1
    while (i < intervals.size) {
        if (intervals[i][0] > end) {
            results.add(intArrayOf(start, end))
            start = intervals[i][0]
            end = intervals[i][1]
        } else {
            end = max(end, intervals[i][1])
        }
        i++
    }
    results.add(intArrayOf(start, end))

    return results.toTypedArray()
}