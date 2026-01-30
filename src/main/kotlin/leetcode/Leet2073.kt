package leetcode

import kotlin.math.min

fun main() {
    println(timeRequiredToBuy(intArrayOf(2,3,2), 2))
    println(timeRequiredToBuy(intArrayOf(5,1,1,1), 0))
}

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    val kval = tickets[k]
    var time = 0
    for (i in tickets.indices) {
        if (i <= k) {
            time += min(tickets[i], kval)
        } else {
            time += min(tickets[i], kval - 1)
        }
    }
    return time
}