package leetcode

import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    println(Solution123().maxProfit(intArrayOf(3,3,5,0,0,3,1,4)))
    println(Solution123().maxProfit(intArrayOf(1,2,3,4,5)))
    println(Solution123().maxProfit(intArrayOf(7,6,4,3,1)))
    println(Solution123().maxProfit(intArrayOf(2,1,2,0,1)))
    println(Solution123().maxProfit(intArrayOf(2,1,4,5,2,9,7)))
    println(Solution123().maxProfit(intArrayOf(8,3,6,2,8,8,8,4,2,0,7,2,9,4,9)))
}

class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var lowest = Int.MAX_VALUE
        var max = 0
        var maxGain = 0
        var priors: MutableMap<Int, Int> = HashMap()
        for (price in prices) {
            if (price <= lowest) {
                lowest = price
                if (priors.isNotEmpty()) {
                    priors.clear()
                    priors[maxGain] = lowest
                }
            } else {
                val gain = price - lowest
                var count = 0
                val oldMax = maxGain
                maxGain = max(maxGain, gain)
                max = max(max, gain)
                for (prior in priors) {
                    if (prior.value < price) {
                        max = max(price - prior.value + prior.key, max)
                    } else if (prior.value > price) {
                        if (prior.value == Int.MAX_VALUE) {
                            val newPotential = prior.key - price
                            priors = priors.filter { it.key > prior.key || it.key - it.value > newPotential }.toMutableMap()
                            count = 0
                        }
                        priors[prior.key] = price
                        count++
                    }
                }

                if (count > 1) {
                    priors = priors.filter { it.value != price || it.key == maxGain }.toMutableMap()
                }

                if (gain !in priors && (priors.isEmpty() || gain > oldMax)) {
                    priors[gain] = Int.MAX_VALUE
                }
            }
        }
        return max
    }
}