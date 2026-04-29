package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    println(Solution79().exist(readArrayOfCharArrays("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCCED"))
    println(Solution79().exist(readArrayOfCharArrays("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "SEE"))
    println(Solution79().exist(readArrayOfCharArrays("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"), "ABCB"))
}

class Solution79 {
    lateinit var brd: Array<CharArray>
    lateinit var w: String

    fun exist(board: Array<CharArray>, word: String): Boolean {
        brd = board
        w = word

        for (x in brd.indices) {
            for (y in brd[x].indices) {
                if (brd[x][y] == w[0]) {
                    if (find(x, y, 0)) {
                        return true
                    }
                }
            }
        }

        return false
    }

    fun find(x: Int, y: Int, pos: Int): Boolean {
        if (pos == w.lastIndex) {
            return true
        } else {
            val buf = brd[x][y]
            brd[x][y] = '$'

            if (x > 0 && brd[x - 1][y] == w[pos + 1]) {
                if(find(x - 1, y, pos + 1)) {
                    return true
                }
            }
            if (x < brd.lastIndex && brd[x + 1][y] == w[pos + 1]) {
                if(find(x + 1, y, pos + 1)) {
                    return true
                }
            }
            if (y > 0 && brd[x][y - 1] == w[pos + 1]) {
                if(find(x, y - 1, pos + 1)) {
                    return true
                }
            }
            if (y < brd[x].lastIndex && brd[x][y + 1] == w[pos + 1]) {
                if(find(x, y + 1, pos + 1)) {
                    return true
                }
            }
            brd[x][y] = buf
        }
        return false
    }
}