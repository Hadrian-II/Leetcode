package leetcode

import helpers.readArrayOfArrays
import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    println(Solution3650().minCost(4, readArrayOfArrays("[[0,1,3],[3,1,1],[2,3,4],[0,2,2]]")))    // 5
    println(Solution3650().minCost(4, readArrayOfArrays("[[0,2,1],[2,1,1],[1,3,1],[2,3,3]]")))    // 3
    println(Solution3650().minCost(2, readArrayOfArrays("[[0,1,2]]")))                            // 2
    println(Solution3650().minCost(3, readArrayOfArrays("[[1,0,7],[1,2,10],[0,1,15],[0,2,4]]")))  // 4
}

class Solution3650 {
    lateinit var map: Array<MutableList<Pair<Int, Int>>>
    lateinit var cost: IntArray

    fun minCost(n: Int, edges: Array<IntArray>): Int {
        map = Array(n) { ArrayList() }
        for (edge in edges) {
            map[edge[0]].add(Pair(edge[1], edge[2]))
            map[edge[1]].add(Pair(edge[0], edge[2] * 2))
        }

        cost = IntArray(n) { Int.MAX_VALUE }
        cost[0] = 0
        calculateCost()
        return if(cost[n - 1] == Int.MAX_VALUE) -1 else cost[n - 1]
    }

    fun calculateCost() {
        val djikstraQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        djikstraQueue.add(0 to 0)
        while (djikstraQueue.isNotEmpty()) {
            val current = djikstraQueue.poll()
            map[current.first].forEach {
                val distance = current.second + it.second
                if (distance < cost[it.first]) {
                    cost[it.first] = distance
                    djikstraQueue.add(it.first to distance)
                }
            }
        }
    }
}