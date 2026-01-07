package leetcode

import java.util.PriorityQueue

fun main() {
    println(totalCost(intArrayOf(17,12,10,2,7,2,11,20,8), 3, 4))
    println(totalCost(intArrayOf(1,2,4,1), 3, 3))
}

fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    val costQueue = ArrayDeque<Int>()
    val firsts = PriorityQueue<Int>()
    val lasts = PriorityQueue<Int>()
    var totalCost = 0L
    for (cost in costs) {
        costQueue.add(cost)
    }
    for (i in 1..candidates) {
        firsts.add(costQueue.removeFirst())
    }
    for (i in 1..candidates) {
        if (costQueue.isNotEmpty()) {
            lasts.add(costQueue.removeLast())
        }
    }
    for (i in 1..k) {
        if ((firsts.peek() ?: Int.MAX_VALUE) <= (lasts.peek() ?: Int.MAX_VALUE)) {
            totalCost += firsts.remove()
            if (costQueue.isNotEmpty()) {
                firsts.add(costQueue.removeFirst())
            }
        } else {
            totalCost += lasts.remove()
            if (costQueue.isNotEmpty()) {
                lasts.add(costQueue.removeLast())
            }
        }
    }
    return totalCost
}