package leetcode

fun main() {
    println(minimumCost(intArrayOf(1,2,3)))
    println(minimumCost(intArrayOf(6,5,7,9,2,2)))
    println(minimumCost(intArrayOf(5,5)))
}

fun minimumCost(cost: IntArray): Int {
    cost.sort()

    var loop = 0
    var sum = 0
    for (c in cost.lastIndex downTo 0) {
        val current = cost[c]
        loop++
        if (loop == 3) {
            loop = 0
        } else {
            sum += current
        }
    }
    return sum
}