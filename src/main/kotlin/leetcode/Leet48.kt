package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    val m = readArrayOfArrays("[[1,2,3],[4,5,6],[7,8,9]]")
    rotate(m)
    m.forEach { printIntArray(it) }

    val m2 = readArrayOfArrays("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]")
    rotate(m2)
    m2.forEach { printIntArray(it) }
}

fun rotate(matrix: Array<IntArray>): Unit {
    val li = matrix.lastIndex
    for(i in 0..<matrix.size / 2) {
        for(j in 0..<li - (2 * i)) {
            val x = i + j
            val lni = li - i
            val lnx = li - x
            val buf = matrix[x][i]
            matrix[x][i] = matrix[lni][x]
            matrix[lni][x] = matrix[lnx][lni]
            matrix[lnx][lni] = matrix[i][lnx]
            matrix[i][lnx] = buf
        }
    }
}