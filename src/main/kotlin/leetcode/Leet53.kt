package leetcode

import kotlin.math.max

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5,4,-1,7,8)))
}

fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var max = Int.MIN_VALUE
    for (num in nums) {
        sum += num
        if (num > sum) {
            sum = num
        }
        max = max(max, sum)
    }
    return max
}