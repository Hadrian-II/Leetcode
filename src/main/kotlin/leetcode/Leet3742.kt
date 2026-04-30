package leetcode

import helpers.readArrayOfArrays
import kotlin.math.max

fun main() {
    println(Solution3742().maxPathScore(readArrayOfArrays("[[0, 1],[2, 0]]"), 1))
    println(Solution3742().maxPathScore(readArrayOfArrays("[[0, 1],[1, 2]]"), 1))
}

class Solution3742 {
    lateinit var grid: Array<IntArray>
    lateinit var result: Array<Array<Map<Int,Int>>>
    val costNScore = arrayOf(Pair(0, 0), Pair(1, 1), Pair(1, 2))
    var k = 0

    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        this.grid = grid
        this.k = k
        val m = grid.size
        val n = grid.first().size
        result = Array(m) { Array(n) { emptyMap() } }
        result[0][0] = costNScore[grid[0][0]].let { mutableMapOf(it.first to it.second)}

        for (i in 1..<m + n) {
            for (j in 0..i) {
                if (i - j in grid.indices && j in grid.first().indices) {
                    process(i-j, j)
                }
            }
        }

        val last = result.last().last()
        return if (last.isEmpty()) -1 else result.last().last().values.max()
    }

    fun process(x: Int, y: Int) {
        val my = costNScore[grid[x][y]]
        val leftValues = if (x > 0) result[x-1][y] else  mapOf()
        val topValues = if (y > 0) result[x][y-1] else  mapOf()

        result[x][y] = (leftValues.keys + topValues.keys)
                             .filter { it + my.first <= k }
                             .associate { it + my.first to
                                          my.second + max(leftValues[it] ?: 0, topValues[it] ?: 0) }
    }
}