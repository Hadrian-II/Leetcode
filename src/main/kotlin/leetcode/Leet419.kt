package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    println(countBattleships(readArrayOfCharArrays("[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]")))
    println(countBattleships(readArrayOfCharArrays("[[\".\"]]")))
}

fun countBattleships(board: Array<CharArray>): Int {
    var battleships = 0
    val maxX = board.size
    val maxY = board.first().size

    for (x in 0 until maxX) {
        for (y in 0 until maxY) {
            if (board[x][y] == 'X' && (x == 0 || board[x - 1][y] == '.') && (y == 0 || board[x][y - 1] == '.')) {
                battleships++
            }
        }
    }

    return battleships
}