package leetcode

import helpers.readArrayOfArrays
import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(minTimeToVisitAllPoints(readArrayOfArrays("[[1,1],[3,4],[-1,0]]")))
    println(minTimeToVisitAllPoints(readArrayOfArrays("[[3,2],[-2,2]]")))
}

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    if (points.size < 2) {
        return 0
    }
    var distance = 0
    for (i in 0..<points.lastIndex) {
        distance += max(abs(points[i][0] - points[i + 1][0]), abs(points[i][1] - points[i + 1][1]))
    }
    return distance
}