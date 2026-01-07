package leetcode

fun main() {
    println(getDescentPeriods(intArrayOf(3,2,1,4)))
    println(getDescentPeriods(intArrayOf(8,6,7,7)))
    println(getDescentPeriods(intArrayOf(1)))
}

fun getDescentPeriods(prices: IntArray): Long {
    var last = prices[0]
    var length = 1
    var descents = 1L
    for (i in 1..prices.lastIndex) {
        if (prices[i] == last - 1) {
            length += 1
        } else {
            length = 1
        }
        descents += length
        last = prices[i]
    }
    return descents
}