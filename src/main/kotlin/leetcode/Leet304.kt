package leetcode

import helpers.readArrayOfArrays

fun main() {
    val t = NumMatrix(readArrayOfArrays("[[3, 0, 1, 4, 2],[5, 6, 3, 2, 1],[1, 2, 0, 1, 5],[4, 1, 0, 1, 7],[1, 0, 3, 0, 5]]"))
    println(t.sumRegion(2,1,4,3))
    println(t.sumRegion(1,1,2,2))
    println(t.sumRegion(1,2,2,4))

    val t2 = NumMatrix(readArrayOfArrays("[[-4,-5]]"))
    println(t2.sumRegion(0,0,0,0))
    println(t2.sumRegion(0,0,0,1))
    println(t2.sumRegion(0,1,0,1))
}

class NumMatrix(matrix: Array<IntArray>) {

    private val pre = Array(matrix.size + 1) { IntArray(matrix.first().size + 1) }

    init {
        val rows =matrix.first().indices
        for (i in matrix.indices) {
            for (j in rows) {
                pre[i + 1][j + 1] = matrix[i][j] + pre[i][j + 1] + pre[i + 1][j] - pre[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1]
    }
}