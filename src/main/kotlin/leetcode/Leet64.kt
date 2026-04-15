package leetcode

import helpers.readArrayOfArrays
import kotlin.math.min

fun main() {
    println(minPathSum(readArrayOfArrays("[[1,3,1],[1,5,1],[4,2,1]]")))
    println(minPathSum(readArrayOfArrays("[[1,2,3],[4,5,6]]")))
}

fun minPathSum(grid: Array<IntArray>): Int {
    val row = IntArray(grid[0].size)
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (j == 0) {
                row[j] += grid[i][j]
            } else if (i == 0) {
                row[j] = row[j - 1] + grid[i][j]
            } else {
                row[j] = min(row[j - 1], row[j]) + grid[i][j]
            }
        }
    }
    return row.last()
}