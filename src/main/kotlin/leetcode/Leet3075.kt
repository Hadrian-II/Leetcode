package leetcode

import kotlin.math.max

fun main() {
    println(maximumHappinessSum(intArrayOf(1,2,3), 2))
    println(maximumHappinessSum(intArrayOf(1,1,1,1), 2))
    println(maximumHappinessSum(intArrayOf(2,3,4,5), 1))
}

fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    happiness.sort()
    var sum = 0L
    for (i in 0..<k) {
        sum += max(happiness[happiness.lastIndex - i] - i, 0)
    }
    return sum
}