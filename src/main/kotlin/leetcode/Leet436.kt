package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    printIntArray(findRightInterval(readArrayOfArrays("[[1,2]]")))
    printIntArray(findRightInterval(readArrayOfArrays("[[3,4],[2,3],[1,2]]")))
    printIntArray(findRightInterval(readArrayOfArrays("[[1,4],[2,3],[3,4]]")))
    printIntArray(findRightInterval(readArrayOfArrays("[[1,12],[2,9],[3,10],[13,14],[15,16],[16,17]]")))
}

fun findRightInterval(intervals: Array<IntArray>): IntArray {
    if (intervals.size == 1) {
        return intArrayOf(if (intervals[0][0] == intervals[0][1]) 0 else -1)
    }
    val lookup = Array(intervals.size) { IntArray(2) }

    for (i in intervals.indices) {
        lookup[i][0] = intervals[i][0]
        lookup[i][1] = i
    }

    lookup.sortBy { it[0] }

    val result = IntArray(intervals.size)
    val last = intervals.lastIndex
    for (i in intervals.indices) {
        val current = intervals[i][1]
        var start = 0
        var end = last
        var mid = 0
        while (start <= end) {
            mid = start + (end - start) / 2
            val check = lookup[mid]
            if (check[0] == current) {
                result[i] = check[1]
                break
            } else if (check[0] > current) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        val look = lookup[mid]
        result[i] = if (current > look[0]) {
            if (mid == last) {
                -1
            } else {
                lookup[mid + 1][1]
            }
        } else {
            look[1]
        }
    }
    return result
}