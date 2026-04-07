package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays
import kotlin.math.max

fun main() {
    println(insert(readArrayOfArrays("[[1,3],[6,9]]"), intArrayOf(2, 5)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[1,2],[3,5],[6,7],[8,10],[12,16]]"), intArrayOf(4, 8)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[1,5]]"), intArrayOf(2, 3)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[4,6]]"), intArrayOf(3, 5)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[4,6]]"), intArrayOf(5, 7)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[1,5]]"), intArrayOf(5, 7)).map { "[${it[0]}, ${it[1]}]" })
    println(insert(readArrayOfArrays("[[1,5]]"), intArrayOf(6, 8)).map { "[${it[0]}, ${it[1]}]" })
}

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if (intervals.isEmpty()) {
        return arrayOf(newInterval)
    }
    val start = findStart(intervals, newInterval)

    var end = findEnd(intervals, newInterval)

    if (intervals[start][0] < newInterval[0] && intervals[start][1] > newInterval[0]) {
        if (intervals[end][0] == newInterval[1]) {
            intervals[start][1] = intervals[end][1]
            end++
        } else {
            intervals[start][1] = max(intervals[start][1], newInterval[1])
        }
    } else if (end == 0) {
        if (intervals[0][0] > newInterval[0]) {
            intervals[0][0] = newInterval[0]
        } else if (intervals[0][1] >= newInterval[0] && intervals[0][1] < newInterval[1]) {
            intervals[0][1] = newInterval[1]
        } else {
            return arrayOf(intervals[0]) + newInterval
        }
    }

    return if (end > start) {
        intervals.sliceArray(0..start) + intervals.sliceArray(end..intervals.lastIndex)
    } else {
        intervals.sliceArray(0..start)
    }
}

private fun findEnd(intervals: Array<IntArray>, newInterval: IntArray): Int {
    var left = 0
    var right = intervals.lastIndex
    var end = 0
    while (left <= right) {
        end = (left + right) / 2
        if (intervals[end][1] < newInterval[1]) {
            left = end + 1
        } else {
            right = end - 1
        }
    }
    return end
}

private fun findStart(intervals: Array<IntArray>, newInterval: IntArray): Int {
    var left = 0
    var right = intervals.lastIndex
    var start = 0
    while (left <= right) {
        start = (left + right) / 2
        if (intervals[start][0] < newInterval[0]) {
            if (intervals[start][1] > newInterval[0]) {
                return start
            }
            left = start + 1
        } else {
            right = start - 1
        }
    }
    return start
}