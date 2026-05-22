package leetcode

import kotlin.math.max
import kotlin.time.measureTime

fun main() {
    println(Solution122().maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(Solution122().maxProfit(intArrayOf(1,2,3,4,5)))
    println(Solution122().maxProfit(intArrayOf(7,6,4,3,1)))
    println(measureTime {
        println(Solution122().maxProfit((-10000..10000).reversed().map { if (it > 0) it else 0 }.toIntArray()))
    })
}

class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0

        var i  = 1
        while (i < prices.size) {
            if (prices[i - 1] < prices[i]) {
                result += prices[i] - prices[i - 1]
            }
            i++
        }

        return result
    }
}