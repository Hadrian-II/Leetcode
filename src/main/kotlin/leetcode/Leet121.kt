package leetcode

import kotlin.math.max

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(maxProfit(intArrayOf(7,6,4,3,1)))
}

fun maxProfit(prices: IntArray): Int {
    var lowest = 100000
    var max = 0
    for (price in prices) {
        if (price < lowest) {
            lowest = price
        } else {
            max = max(price - lowest, max)
        }
    }
    return max
}