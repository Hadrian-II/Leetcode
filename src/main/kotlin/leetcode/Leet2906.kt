package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    constructProductMatrix(readArrayOfArrays("[[1,2],[3,4]]")).forEach { printIntArray(it) }
    println("------------")
    constructProductMatrix(readArrayOfArrays("[[12345],[2],[1]]")).forEach { printIntArray(it) }
    println("------------")
    constructProductMatrix(readArrayOfArrays("[[414750857],[449145368],[767292749]]")).forEach { printIntArray(it) }
}

fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
    val mod = 12345
    var preSum = 1
    var postSum = 1
    val preArray = Array(grid.size) { IntArray(grid[0].size) }
    val postArray = Array(grid.size) { IntArray(grid[0].size) }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            preSum *= (grid[i][j] % mod)
            preSum %= mod
            preArray[i][j] = preSum

            val ii = grid.lastIndex - i
            val ij = grid[i].lastIndex - j
            postSum *= (grid[ii][ij] % mod)
            postSum %= mod
            postArray[ii][ij] = postSum
        }
    }

    val result = Array(grid.size) { IntArray(grid[0].size) }
    if (grid[0].lastIndex == 0) {
        for (i in grid.indices) {
            result[i][0] = when (i) {
                0 ->              postArray[i + 1][0]
                grid.lastIndex -> preArray[i - 1][0]
                else ->           (preArray[i - 1][0] * postArray[i + 1][0]) % mod
            }
        }
    } else {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                result[i][j] =
                    if (j == 0) {
                        if (i == 0) {
                            postArray[i][j + 1]
                        } else {
                            (preArray[i - 1][grid[i].lastIndex] * postArray[i][j + 1]) % mod
                        }
                    } else if (j == grid[i].lastIndex) {
                        if (i == grid.lastIndex) {
                            preArray[i][j - 1]
                        } else {
                            (preArray[i][j - 1] * postArray[i + 1][0]) % mod
                        }
                    } else {
                        (preArray[i][j - 1] * postArray[i][j + 1]) % mod
                    }
            }
        }
    }

    return result
}