package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(numSpecial(readArrayOfArrays("[[1,0,0],[0,0,1],[1,0,0]]")))
    println(numSpecial(readArrayOfArrays("[[1,0,0],[0,1,0],[0,0,1]]")))
}

fun numSpecial(mat: Array<IntArray>): Int {
    val rows = IntArray(mat.size)
    val cols = IntArray(mat[0].size)

    var i = 0
    while (i < mat.size) {
        var j = 0
        while (j < mat[i].size) {
            if (mat[i][j] == 1) {
                rows[i]++
                cols[j]++
            }
            j++
        }
        i++
    }

    var special = 0
    i = 0
    while (i < mat.size) {
        var j = 0
        while (j < mat[i].size) {
            if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                special++
            }
            j++
        }
        i++
    }
    return special
}