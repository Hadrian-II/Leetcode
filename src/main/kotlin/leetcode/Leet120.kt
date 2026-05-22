package leetcode

import helpers.readListOfLists
import kotlin.math.min

fun main() {
    println(minimumTotal(readListOfLists("[[2],[3,4],[6,5,7],[4,1,8,3]]")))
    println(minimumTotal(readListOfLists("[[-10]]")))
}

fun minimumTotal(triangle: List<List<Int>>): Int {
    val results = triangle.last().toIntArray()

    var i = triangle.lastIndex - 1
    while (i >= 0) {
        for (j in triangle[i].indices) {
            results[j] = triangle[i][j] + min(results[j], results[j + 1])
        }
        i--
    }

    return results.first()
}