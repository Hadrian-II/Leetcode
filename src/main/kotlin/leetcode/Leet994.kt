package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(orangesRotting(readArrayOfArrays("[[2,1,1],[1,1,0],[0,1,1]]")))
    println(orangesRotting(readArrayOfArrays("[[2,1,1],[0,1,1],[1,0,1]]")))
    println(orangesRotting(readArrayOfArrays("[[0,2]]")))
}

fun orangesRotting(grid: Array<IntArray>): Int {
    var igrid = grid
    var rotted = true
    var time = -1
    val FRESH = 1
    val ROTTEN = 2
    while(rotted) {
        time++
        rotted = false
        igrid = igrid.mapIndexed { i, row -> row.mapIndexed { j, cell ->
            if (cell == FRESH && (i > 0 && igrid[i - 1][j] == ROTTEN ||
                        i < igrid.lastIndex && igrid[i + 1][j] == ROTTEN ||
                        j > 0 && igrid[i][j - 1] == ROTTEN ||
                        j < igrid[0].lastIndex && igrid[i][j + 1] == ROTTEN)) {
                rotted = true
                ROTTEN
            } else {
                cell
            }
        }.toIntArray() }.toTypedArray()
    }
    return if(igrid.any { row -> row.any { it == FRESH } }) {
        -1
    } else {
        time
    }
}