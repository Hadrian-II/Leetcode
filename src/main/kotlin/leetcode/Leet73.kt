package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    val i1 = readArrayOfArrays("[[1,1,1],[1,0,1],[1,1,1]]")
    setZeroes(i1)
    i1.forEach { printIntArray(it) }

    val i2 = readArrayOfArrays("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]")
    setZeroes(i2)
    i2.forEach { printIntArray(it) }
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    val zeroLine = BooleanArray(matrix[0].size)
    for (i in matrix.indices) {
        val line = matrix[i]
        var hasZero = false
        for (j in line.indices) {
            if (line[j] == 0) {
                if (i > 0 && !zeroLine[j]) {
                    for (k in 0..<i) {
                        matrix[k][j] = 0
                    }
                }
                zeroLine[j] = true
                if (j > 0 && !hasZero) {
                    for(k in 0..<j) {
                        line[k] = 0
                    }
                }
                hasZero = true
            } else if (zeroLine[j] || hasZero) {
                line[j] = 0
            }
        }
    }
}