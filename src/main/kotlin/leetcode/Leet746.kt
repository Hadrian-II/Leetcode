package leetcode

import kotlin.math.min

fun main() {
    println(minCostClimbingStairs(intArrayOf(10,15,20)))
    println(minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
}

fun minCostClimbingStairs(cost: IntArray): Int {
    val result = IntArray(cost.size + 2) {Int.MAX_VALUE}
    result[0] = 0
    result[1] = 0
    for (i in cost.indices) {
        val currentCost = result[i] + cost[i]
        if (result[i + 1] > currentCost) {
            result[i + 1] = currentCost
        }
        if (result[i + 2] > currentCost) {
            result[i + 2] = currentCost
        }
    }
    return min(result[result.lastIndex], result[result.lastIndex - 1])
}