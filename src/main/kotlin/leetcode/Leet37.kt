package leetcode

import helpers.readArrayOfCharArrays
import kotlin.time.measureTime

fun main() {
//    val board = readArrayOfCharArrays("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]")
//    Solution37().solveSudoku(board)
//    board.forEach { println(it.joinToString(", "))}
//    val b2 = readArrayOfCharArrays("[[\".\",\".\",\"9\",\"7\",\"4\",\"8\",\".\",\".\",\".\"],[\"7\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"1\",\".\",\"9\",\".\",\".\",\".\"],[\".\",\".\",\"7\",\".\",\".\",\".\",\"2\",\"4\",\".\"],[\".\",\"6\",\"4\",\".\",\"1\",\".\",\"5\",\"9\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\"3\",\".\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\"3\",\".\",\"2\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"6\"],[\".\",\".\",\".\",\"2\",\"7\",\"5\",\"9\",\".\",\".\"]]")
//    Solution37().solveSudoku(b2)
//    b2.forEach { println(it.joinToString(", "))}
    val b3 = readArrayOfCharArrays("[[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"9\",\".\",\".\",\"1\",\".\",\".\",\"3\",\".\"],[\".\",\".\",\"6\",\".\",\"2\",\".\",\"7\",\".\",\".\"],[\".\",\".\",\".\",\"3\",\".\",\"4\",\".\",\".\",\".\"],[\"2\",\"1\",\".\",\".\",\".\",\".\",\".\",\"9\",\"8\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\"2\",\"5\",\".\",\"6\",\"4\",\".\",\".\"],[\".\",\"8\",\".\",\".\",\".\",\".\",\".\",\"1\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]")
    println(measureTime {
        Solution37().solveSudoku(b3)
    })
    b3.forEach { println(it.joinToString(", "))}
}

class Solution37 {
    lateinit var brd: Array<CharArray>
    val nrs = (1..9).map { it.toString()[0] }.toMutableSet()
    val rows = Array(9) { nrs.toMutableSet() }
    var cols = Array(9) { nrs.toMutableSet() }
    var subs = Array(3) { Array(3) { nrs.toMutableSet() } }
    var valid = true

    fun solveSudoku(board: Array<CharArray>) {
        brd = board
        readBoard()
        simpleSolve()
        if (!valid) {
            return
        }

        if (brd.any{ it.any{ c -> c == '.'}}) {
            val rowMin = rows.filter { it.isNotEmpty() }.minOf { it.size }

            val coord = emptyFromRow(rowMin)

            val possibilities = rows[coord.first].intersect(cols[coord.second]).intersect(subs[coord.first / 3][coord.second / 3])
            for (p in possibilities) {
                val nbr = brd.map { it.copyOf() }.toTypedArray()
                nbr[coord.first][coord.second] = p
                Solution37().solveSudoku(nbr)
                if (nbr.all { it.all { c -> c != '.' } }) {
                    for (k in brd.indices) {
                        for (l in brd.indices) {
                            brd[k][l] = nbr[k][l]
                        }
                    }
                    return
                }
            }
        }
    }

    private fun emptyFromRow(rowMin: Int): Pair<Int, Int> {
        for (i in rows.indices) {
            if (rows[i].size == rowMin) {
                for (j in brd.indices) {
                    if (brd[i][j] == '.') {
                        return Pair(i, j)
                    }
                }
            }
        }
        return Pair(-1, -1)
    }

    private fun simpleSolve() {
        var changed = true
        while (changed) {
            changed = false
            for (i in brd.indices) {
                for (j in brd.indices) {
                    if (brd[i][j] == '.') {
                        val used = rows[i].intersect(cols[j]).intersect(subs[i / 3][j / 3])
                        if (used.size == 1) {
                            val current = used.first()
                            update(i, j, current)
                            brd[i][j] = current
                            changed = true
                        } else if (used.isEmpty()) {
                            valid = false
                            return
                        }
                    }
                }
            }
        }
    }

    private fun readBoard() {
        for (i in brd.indices) {
            for (j in brd.indices) {
                val current = brd[i][j]
                if (current != '.') {
                    update(i, j, current)
                }
            }
        }
    }

    fun update(i: Int, j: Int, current: Char) {
        rows[i].remove(current)
        cols[j].remove(current)
        subs[i / 3][j / 3].remove(current)
    }
}