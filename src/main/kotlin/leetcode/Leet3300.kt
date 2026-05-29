package leetcode

import kotlin.math.min

fun main() {
    println(minElement(intArrayOf(10,12,13,14)))
    println(minElement(intArrayOf(1,2,3,4)))
    println(minElement(intArrayOf(999,19,199)))
}

fun minElement(nums: IntArray): Int {
    var min = Int.MAX_VALUE

    for (i in nums.indices) {
        var value = nums[i]
        var sum = 0
        while (value > 0) {
            sum += value % 10
            value /= 10
        }
        min = min(min, sum)
    }

    return min
}