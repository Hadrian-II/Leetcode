package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    printIntArray(findDiagonalOrder(readArrayOfArrays("[[1,2,3],[4,5,6],[7,8,9]]")))
    printIntArray(findDiagonalOrder(readArrayOfArrays("[[1,2],[3,4]]")))
}

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val xmax = mat.lastIndex
    val ymax = mat.first().lastIndex
    val max = mat.size * mat.first().size
    val result = IntArray(max)
    var rptr = 0
    var x = 0
    var y = 0
    var up = true
    while (rptr < max) {
        result[rptr++] = mat[x][y]
        if (up) {
            if (y == ymax) {
                x++
                up = false
            }
            else if (x == 0) {
                y++
                up = false
            } else {
                x--
                y++
            }
        } else {
            if (x == xmax) {
                y++
                up = true
            } else if (y == 0) {
                x++
                up = true
            } else {
                x++
                y--
            }
        }
    }

    return result
}