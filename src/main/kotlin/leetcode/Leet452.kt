package leetcode

import helpers.readArrayOfArrays
import kotlin.math.min

fun main() {
    println(findMinArrowShots(readArrayOfArrays("[[10,16],[2,8],[1,6],[7,12]]")))
    println(findMinArrowShots(readArrayOfArrays("[[1,2],[3,4],[5,6],[7,8]]")))
    println(findMinArrowShots(readArrayOfArrays("[[1,2],[2,3],[3,4],[4,5]]")))
}

fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    var current = Int.MAX_VALUE
    var arrows = 0
    for (i in points.indices) {
        if (points[i][0] > current) {
            arrows++
            current = points[i][1]
        } else {
            current = min(current, points[i][1])
        }
    }
    return arrows + 1
}