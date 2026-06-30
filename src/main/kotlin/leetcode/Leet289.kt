package leetcode

import helpers.printIntArray
import helpers.readArrayOfArrays

fun main() {
    val g1 = readArrayOfArrays("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]")
    gameOfLife(g1)
    g1.forEach { printIntArray(it) }

    val g2 = readArrayOfArrays("[[1,1],[1,0]]")
    gameOfLife(g2)
    g2.forEach { printIntArray(it) }

    val g3 = readArrayOfArrays("[[0,1,0,0,1,1,0],[1,1,1,1,1,1,1],[1,1,0,0,0,0,1],[1,1,0,0,1,0,0]]")
    gameOfLife(g3)
    g3.forEach { printIntArray(it) }
}

fun gameOfLife(board: Array<IntArray>): Unit {
    val dies = 2
    val births = -1
    val maxX = board.lastIndex
    val maxY = board.first().lastIndex
    for (x in board.indices) {
        for (y in board[x].indices) {
            var neighbours = 0
            val hasLeft = x > 0
            val hasRight = x < maxX
            val hasTop = y > 0
            val hasBottom = y < maxY

            if (hasLeft && board[x - 1][y] > 0) {
                neighbours++
            }
            if (hasLeft && hasTop && board[x - 1][y - 1] > 0) {
                neighbours++
            }
            if (hasTop && board[x][y - 1] > 0) {
                neighbours++
            }
            if (hasTop && hasRight && board[x + 1][y - 1] > 0) {
                neighbours++
            }
            if (hasRight && board[x + 1][y] > 0) {
                neighbours++
            }
            if (hasRight && hasBottom && board[x + 1][y + 1] > 0) {
                neighbours++
            }
            if (hasBottom && board[x][y + 1] > 0) {
                neighbours++
            }
            if (hasBottom && hasLeft && board[x - 1][y + 1] > 0) {
                neighbours++
            }
            if (board[x][y] == 1 && (neighbours != 2 && neighbours != 3)) {
                board[x][y] = dies
            } else if (board[x][y] == 0 && neighbours == 3) {
                board[x][y] = births
            }
        }
    }

    for (x in board.indices) {
        for (y in board[x].indices) {
            val value = board[x][y]
            if (value == dies) {
                board[x][y] = 0
            } else if (value == births) {
                board[x][y] = 1
            }
        }
    }
}