package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    println(isValidSudoku(readArrayOfCharArrays("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]")))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    for (i in board.indices) {
        var checkSet = mutableSetOf<Char>()
        for (j in board.indices) {
            val current = board[i][j]
            if (current == '.') {
                continue
            }
            if (current in checkSet) {
                return false
            }
            checkSet.add(current)
        }

        checkSet = mutableSetOf()
        for (j in board.indices) {
            val current = board[j][i]
            if (current == '.') {
                continue
            }
            if (current in checkSet) {
                return false
            }
            checkSet.add(current)
        }
    }

    val trange = 0..2
    for (i in trange) {
        for (j in trange) {
            val checkSet = mutableSetOf<Char>()
            for (k in trange) {
                for (l in trange) {
                    val current = board[i * 3 + k][j * 3 + l]
                    if (current == '.') {
                        continue
                    }
                    if (current in checkSet) {
                        return false
                    }
                    checkSet.add(current)
                }
            }
        }
    }

    return true
}