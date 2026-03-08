package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    println(Solution200().numIslands(readArrayOfCharArrays("[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]")))
    println(Solution200().numIslands(readArrayOfCharArrays("[[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"1\",\"1\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\"],[\"0\",\"0\",\"0\",\"1\",\"1\"]]")))
}

class Solution200 {
    lateinit var map: Array<CharArray>

    fun numIslands(grid: Array<CharArray>): Int {
        map = grid
        var islands = 0
        for (i in map.indices) {
            for (j in map[0].indices) {
                if (map[i][j] == '1') {
                    islands++
                    removeIsland(i, j)
                }
            }
        }
        return islands
    }

    fun removeIsland(x: Int, y: Int) {
        map[x][y] = '0'
        if (x > 0 && map[x - 1][y] == '1') {
            removeIsland(x - 1, y)
        }
        if (x < map.lastIndex && map[x + 1][y] == '1') {
            removeIsland(x + 1, y)
        }
        if (y > 0 && map[x][y - 1] == '1') {
            removeIsland(x, y - 1)
        }
        if (y < map[x].lastIndex && map[x][y + 1] == '1') {
            removeIsland(x, y + 1)
        }
    }
}