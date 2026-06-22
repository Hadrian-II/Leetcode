package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(Solution240().searchMatrix(readArrayOfArrays("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 5))
    println(Solution240().searchMatrix(readArrayOfArrays("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 20))
}

class Solution240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var high = matrix.first().lastIndex
        for (row in matrix) {
            if (row.first() > target) {
                return false
            }
            var low = 0

            while (low <= high) {
                val mid = (low + high) / 2
                val num = row[mid]
                if (num == target) {
                    return true
                } else if (num > target) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
        }
        return false
    }
}