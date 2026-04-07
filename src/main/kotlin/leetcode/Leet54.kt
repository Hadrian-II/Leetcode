package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(spiralOrder(readArrayOfArrays("[[1,2,3],[4,5,6],[7,8,9]]")))
    println(spiralOrder(readArrayOfArrays("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")))
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    var top = 0
    var right = matrix[0].lastIndex
    var bottom = matrix.lastIndex
    var left = 0
    while (top <= bottom || left <= right) {
        if (top <= bottom) {
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++
        }
        if (right >= left) {
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--
        }
        if (bottom >= top) {
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }
    return result
}