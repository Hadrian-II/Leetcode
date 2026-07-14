package leetcode

import kotlin.math.max

fun main() {
    println(Solution309().maxProfit(intArrayOf(1,2,3,0,2)))
    println(Solution309().maxProfit(intArrayOf(1)))
}

class Solution309 {
    private lateinit var prices: IntArray
    lateinit var memo: Array<IntArray>

    fun maxProfit(prices: IntArray): Int {
        this.prices = prices
        memo = Array(prices.size) { intArrayOf(-1, -1) }
        return getMaxProfit(0,0)
    }

    fun getMaxProfit(day: Int, holds: Int): Int {
        if (day > memo.lastIndex) {
            return 0
        }

        if (memo[day][holds] == -1) {
            memo[day][holds] = if (day == prices.lastIndex) {
                if (holds == 1) prices.last() else 0
            } else if (holds == 1) {
                max(prices[day] + getMaxProfit(day + 2, 0), getMaxProfit(day + 1, 1))
            } else {
                max(-prices[day] + getMaxProfit(day + 1, 1), getMaxProfit(day + 1, 0))
            }
        }
        return memo[day][holds]
    }
}