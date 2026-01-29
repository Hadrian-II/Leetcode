package leetcode

import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    println(Solution2976().minimumCost("abcd", "acbe", charArrayOf('a', 'b', 'c', 'c', 'e', 'd'), charArrayOf('b', 'c', 'b', 'e', 'b', 'e'), intArrayOf(2,5,5,1,2,20)))
    println(Solution2976().minimumCost("aaaa", "bbbb", charArrayOf('a', 'c'), charArrayOf('c', 'b'), intArrayOf(1, 2)))
    println(Solution2976().minimumCost("abcd", "abce", charArrayOf('a'), charArrayOf('e'), intArrayOf(1000)))
    println(Solution2976().minimumCost("aabbddccbc", "abbbaabaca", charArrayOf('a','b','c','b','a','d'), charArrayOf('d','c','b','d','b','b'), intArrayOf(3,8,7,6,7,10)))
    println(Solution2976().minimumCost("abadcdadac", "baddbccdac", charArrayOf('d','c','d','c','b','a'), charArrayOf('b','b','c','a','d','d'), intArrayOf(8,5,9,1,10,2)))
}

class Solution2976() {
    val aInt = 'a'.code
    val costMap = Array(26) { LongArray(26) { Long.MAX_VALUE} }

    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val alphabet = 0..<26
        for (i in alphabet) {
            costMap[i][i] = 0
        }

        for (i in original.indices) {
            val x = original[i].code - aInt
            val y = changed[i].code - aInt
            costMap[x][y] = min(costMap[x][y], cost[i].toLong())
        }

        for (k in alphabet) {
            for (i in alphabet) {
                if (costMap[i][k] == Long.MAX_VALUE) {
                    continue
                }
                for (j in alphabet) {
                    if (costMap[k][j] != Long.MAX_VALUE) {
                        costMap[i][j] = min(costMap[i][j], costMap[i][k] + costMap[k][j])
                    }
                }
            }
        }

        var sum = 0L
        for (i in source.indices) {
            val current = costMap[source[i].code - aInt][target[i].code - aInt]
            if (current == Long.MAX_VALUE) {
                return -1
            }
            sum += current
        }

        return sum
    }
}