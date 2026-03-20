package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(countSubmatrices(readArrayOfArrays("[[7,6,3],[6,6,1]]"), 18))
    println(countSubmatrices(readArrayOfArrays("[[7,2,9],[1,5,0],[2,6,6]]"), 20))
}

fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
    var fits = 0
    var lastLine = mutableListOf<Int>()
    for (i in grid.indices) {
        val line = mutableListOf<Int>()
        var current = 0
        for (j in grid[i].indices) {
            if (i > 0 && j > lastLine.lastIndex) {
                break
            }
            current += grid[i][j]
            val sum = current + if (i > 0) lastLine[j] else 0
            if (sum <= k) {
                fits++
                if (sum < k) {
                    line.add(sum)
                } else {
                    break
                }
            } else {
                break
            }
        }
        lastLine = line
    }
    return fits
}