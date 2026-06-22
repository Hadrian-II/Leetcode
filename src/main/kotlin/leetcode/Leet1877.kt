package leetcode

import kotlin.math.max

fun main() {
    println(minPairSum(intArrayOf(3,5,2,3)))
    println(minPairSum(intArrayOf(3,5,4,2,4,6)))
}

fun minPairSum(nums: IntArray): Int {
    nums.sort()
    var max = 0
    val li = nums.lastIndex
    for (i in 0..li/2) {
        max = max(max, nums[i] + nums[li - i])
    }
    return max
}