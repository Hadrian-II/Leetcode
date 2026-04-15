package leetcode

import helpers.readArrayOfArrays
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(uniquePathsWithObstacles(readArrayOfArrays("[[0,0,0],[0,1,0],[0,0,0]]")))
    println(uniquePathsWithObstacles(readArrayOfArrays("[[0,1],[0,0]]")))
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid.size == 1) {
        return if (obstacleGrid[0].any { it == 1}) 0 else 1
    } else if (obstacleGrid[0].size == 1) {
        return if (obstacleGrid.any { it[0] == 1}) 0 else 1
    } else if (obstacleGrid[0][0] == 1) {
        return 0
    }

    val pathGrid = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }
    pathGrid[0][0] = 1

    for (i in 1..(obstacleGrid.lastIndex + obstacleGrid[0].lastIndex)) {
        var x = min(i, obstacleGrid.lastIndex)
        var y = max(0, i - obstacleGrid.lastIndex)
        while (x >= 0 && y <= obstacleGrid[0].lastIndex) {
            if (obstacleGrid[x][y] == 1) {
                pathGrid[x][y] = 0
            } else {
                pathGrid[x][y] = (if (x > 0) pathGrid[x - 1][y] else 0) + (if (y > 0) pathGrid[x][y - 1] else 0)
            }
            x--
            y++
        }
    }
    return pathGrid.last().last()
}