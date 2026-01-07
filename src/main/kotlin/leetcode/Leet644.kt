package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(findMaxAverage(intArrayOf(1,12,-5,-6,50, 3), 4))
    println(findMaxAverage(intArrayOf(5), 1))
    println(findMaxAverage(intArrayOf(-1), 1))
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    val kdbl = k.toDouble()
    var current = 0
    var max = -100000.0
    nums.forEachIndexed {
        index, item ->
        current += item
        if (index >= k) {
            current -= nums[index - k]
        }
        if (index >= k - 1) {
            max = max(max, current / kdbl)
        }
    }
    return max
}