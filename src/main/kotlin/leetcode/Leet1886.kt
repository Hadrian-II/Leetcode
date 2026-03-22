package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(findRotation(readArrayOfArrays("[[0,1],[1,0]]"), readArrayOfArrays("[[1,0],[0,1]]")))
    println(findRotation(readArrayOfArrays("[[0,1],[1,1]]"), readArrayOfArrays("[[1,0],[0,1]]")))
    println(findRotation(readArrayOfArrays("[[0,0,0],[0,1,0],[1,1,1]]"), readArrayOfArrays("[[1,1,1],[0,1,0],[0,0,0]]")))
}

fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    var same = true
    var quarter = true
    var half = true
    var threeQuarter = true
    var i = 0
    val li = mat.size -1
    while (i < mat.size) {
        var j = 0
        while (j < mat.size) {
            if (mat[i][j] != target[i][j]) {
                same = false
            }
            if (mat[i][j] != target[j][li - i]) {
                quarter = false
            }
            if (mat[i][j] != target[li - i][li - j]) {
                half = false
            }
            if (mat[i][j] != target[li - j][i]) {
                threeQuarter = false
            }
            j++
        }
        if (!same && !quarter && !half && !threeQuarter) {
            return false
        }
        i++
    }

    return true
}