package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(searchMatrix(readArrayOfArrays("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3))
    println(searchMatrix(readArrayOfArrays("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 13))
    println(searchMatrix(readArrayOfArrays("[[1]]"), 2))
    println(searchMatrix(readArrayOfArrays("[[1,2,3,4,5,6]]"), 7))
    println(searchMatrix(readArrayOfArrays("[[1],[2],[3]]"), 2))
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var start = 0
    var end = matrix.size * matrix[0].size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        val valueAtMid = matrix[mid / matrix[0].size][mid % matrix[0].size]
        if (valueAtMid == target) {
            return true
        } else if (valueAtMid > target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return false
}