package leetcode

import helpers.printIntArray
import kotlin.math.abs

fun main() {
    printIntArray(leftRightDifference(intArrayOf(10,4,8,3)))
    printIntArray(leftRightDifference(intArrayOf(1)))
}

fun leftRightDifference(nums: IntArray): IntArray {
    val sums = IntArray(nums.size)
    var sum = 0
    for (i in 0..<nums.lastIndex) {
        sums[i] = sum
        sum += nums[i]
    }
    sums[sums.lastIndex] = sum

    sum = 0
    for (i in nums.lastIndex downTo 0) {
        sums[i] = abs(sums[i] - sum)
        sum += nums[i]
    }

     return sums
}