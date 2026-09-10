package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(islandPerimeter(readArrayOfArrays("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]")))
    println(islandPerimeter(readArrayOfArrays("[[1]]")))
    println(islandPerimeter(readArrayOfArrays("[[1,0]]")))
}

fun islandPerimeter(grid: Array<IntArray>): Int {
    var perimeter = 0
    var lastRow = IntArray(0)
    val lastX = grid.lastIndex
    val lastY = grid.first().lastIndex
    for (i in grid.indices) {
        val row = grid[i]
        var last = 0
        for (j in row.indices) {
            val current = row[j]

            if (current == 1) {
                if (last == 0) {
                    perimeter++
                }
                if (j == lastY || row[j + 1] == 0) {
                    perimeter++
                }
                if (i == 0 || lastRow[j] == 0) {
                    perimeter++
                }
                if (i == lastX || grid[i + 1][j] == 0) {
                    perimeter++
                }
            }

            last = current
        }
        lastRow = row
    }

    return perimeter
}