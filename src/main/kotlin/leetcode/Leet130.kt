package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    val brd = readArrayOfCharArrays("[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]")
    Solution130().solve(brd)
    val brd2 = readArrayOfCharArrays("[[\"X\"]]")
    Solution130().solve(brd2)
    val brd3 = readArrayOfCharArrays("[[\"X\",\"X\",\"X\",\"X\",\"O\"],[\"X\",\"O\",\"O\",\"X\",\"X\"],[\"O\",\"X\",\"X\",\"X\",\"X\"]]")
    Solution130().solve(brd3)
    val x = 5
}

class Solution130 {
    val wall = 'X'
    val free = 'O'
    val saved = 'Q'
    lateinit var board: Array<CharArray>


    fun solve(board: Array<CharArray>): Unit {
        this.board = board

        for (i in board.indices) {
            if (board[i].first() == free) {
                save(i, 0)
            }
            if (board[i].last() == free) {
                save(i, board[i].lastIndex)
            }
        }

        for (i in 1..<board.first().lastIndex) {
            if (board.first()[i] == free) {
                save(0, i)
            }
            if (board.last()[i] == free) {
                save(board.lastIndex, i)
            }
        }

        for (i in board.indices) {
            for (j in board.first().indices) {
                if (board[i][j] == saved) {
                    board[i][j] = free
                } else if(board[i][j] == free) {
                    board[i][j] = wall
                }
            }
        }
    }

    fun save(x: Int, y: Int) {
        board[x][y] = saved

        if (x > 0 && board[x - 1][y] == free) {
            save(x - 1, y)
        }
        if (x < board.lastIndex && board[x + 1][y] == free) {
            save(x + 1, y)
        }
        if (y > 0 && board[x][y - 1] == free) {
            save(x, y - 1)
        }
        if (y < board.first().lastIndex && board[x][y + 1] == free) {
            save(x, y + 1)
        }
    }
}