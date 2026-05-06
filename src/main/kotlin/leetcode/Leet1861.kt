package leetcode

import helpers.readArrayOfCharArrays

fun main() {
    Solution1861().rotateTheBox(readArrayOfCharArrays("[[\"#\",\".\",\"#\"]]")).forEach { println(it) }
    println()
    Solution1861().rotateTheBox(readArrayOfCharArrays("[[\"#\",\".\",\"*\",\".\"],[\"#\",\"#\",\"*\",\".\"]]")).forEach { println(it) }
    println()
    Solution1861().rotateTheBox(readArrayOfCharArrays("[[\"#\",\"#\",\"*\",\".\",\"*\",\".\"],[\"#\",\"#\",\"#\",\"*\",\".\",\".\"],[\"#\",\"#\",\"#\",\".\",\"#\",\".\"]]")).forEach { println(it) }
}

class Solution1861 {
    lateinit var result: Array<CharArray>
    var lastObstacle = 0
    var rockCount = 0

    fun rotateTheBox(boxGrid: Array<CharArray>): Array<CharArray> {
        result = Array(boxGrid.first().size) { CharArray(boxGrid.size) { '.' } }

        for (i in boxGrid.indices.reversed()) {
            val column = boxGrid[i]
            lastObstacle = column.size

            for (j in column.indices.reversed()) {
                val element = column[j]
                if (element == '#') {
                    rockCount++
                } else if (element == '*') {
                    setRocks(boxGrid, i)
                    result[j][boxGrid.lastIndex - i] = '*'
                    lastObstacle = j
                }

                if (j == 0) {
                    setRocks(boxGrid, i)
                }
            }
        }

        return result
    }

    private fun setRocks(boxGrid: Array<CharArray>, i: Int) {
        while (rockCount > 0) {
            result[--lastObstacle][boxGrid.lastIndex - i] = '#'
            rockCount--
        }
    }
}