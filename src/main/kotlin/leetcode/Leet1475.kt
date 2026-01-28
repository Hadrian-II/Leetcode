package leetcode

import helpers.printIntArray
import java.util.PriorityQueue

fun main() {
    printIntArray(finalPrices(intArrayOf(8,4,6,2,3)))
    printIntArray(finalPrices(intArrayOf(1,2,3,4,5)))
    printIntArray(finalPrices(intArrayOf(10,1,1,6)))
    printIntArray(finalPrices(intArrayOf(5,4,10,2,6,1,1,1,9,1)))
}

fun finalPrices(prices: IntArray): IntArray {
    val result = IntArray(prices.size)
    val cheapest = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    for (i in prices.indices.reversed()) {
        var discount = Pair(0,Int.MAX_VALUE)
        for (cheap in cheapest) {
            if (cheap.first <= prices[i] && cheap.first > discount.first && cheap.second < discount.second) {
                discount = cheap
                if (discount.first == prices[i]) {
                    break
                }
            }
        }
        result[i] = prices[i] - discount.first

        while ((cheapest.peek()?.first ?: -1) >= prices[i]) {
            cheapest.poll()
        }

        cheapest.add(Pair(prices[i], i))
    }

    return result
}