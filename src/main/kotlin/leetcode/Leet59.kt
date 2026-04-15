package leetcode

import helpers.printIntArray

fun main() {
    generateMatrix(3).forEach { printIntArray(it) }
    generateMatrix(1).forEach { printIntArray(it) }
}

fun generateMatrix(n: Int): Array<IntArray> {
    val result = Array(n) {IntArray(n)}
    var top = 0
    var right = n - 1
    var bottom = n - 1
    var left = 0
    var current = 1
    while (top <= bottom || left <= right) {
        if (top <= bottom) {
            for (i in left..right) {
                result[top][i] = current++
            }
            top++
        }
        if (right >= left) {
            for (i in top..bottom) {
                result[i][right] = current++
            }
            right--
        }
        if (bottom >= top) {
            for (i in right downTo left) {
                result[bottom][i] = current++
            }
            bottom--
        }
        if (left <= right) {
            for (i in bottom downTo top) {
                result[i][left] = current++
            }
            left++
        }
    }
    return result
}