package leetcode

import helpers.readArrayOfCharArrays
import kotlin.math.min

fun main() {
    println(Solution1926().nearestExit(readArrayOfCharArrays("[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]]"), intArrayOf(1,2)))
    println(Solution1926().nearestExit(readArrayOfCharArrays("[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]"), intArrayOf(1,0)))
    println(Solution1926().nearestExit(readArrayOfCharArrays("[[\".\",\"+\"]]"), intArrayOf(0,0)))
}

class Solution1926 {
    val WALL = -77
    val UNTOUCHED = Int.MAX_VALUE
    val INPUTWALL = '+'
    lateinit var imaze: Array<Array<Int>>

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        imaze = maze.map { row -> row.map { if (it == INPUTWALL) WALL else UNTOUCHED }.toTypedArray() }.toTypedArray()
        walk(entrance[0], entrance[1], 0)
        val closestTopBottom = (imaze[0] + imaze[imaze.lastIndex]).filter { isReachedExit(it) }.minOrNull()
        val closestLeftRight = (1..<imaze.lastIndex)
            .map { arrayOf(imaze[it][0], imaze[it][imaze[0].lastIndex]) }.toTypedArray().flatten()
            .filter { isReachedExit(it) }.minOrNull()
        return if (closestTopBottom == null) {
            closestLeftRight ?: -1
        } else {
            min(closestTopBottom, closestLeftRight ?: Int.MAX_VALUE)
        }
    }

    private fun isReachedExit(i: Int): Boolean = i != 0 && i != UNTOUCHED && i != WALL

    fun walk(x: Int, y: Int, steps: Int) {
        if (imaze[x][y] != WALL && steps < imaze[x][y]) {
            imaze[x][y] = steps
            if (y > 0) {
                walk(x, y - 1, steps + 1)
            }
            if (y < imaze[0].lastIndex) {
                walk(x, y + 1, steps + 1)
            }
            if (x > 0) {
                walk(x - 1, y, steps + 1)
            }
            if (x < imaze.lastIndex) {
                walk(x + 1, y, steps + 1)
            }
        }
    }
}