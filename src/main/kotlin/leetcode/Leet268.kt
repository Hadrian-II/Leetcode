package leetcode

import kotlin.math.min

fun main() {
    println(missingNumber(intArrayOf(3,0,1)))
    println(missingNumber(intArrayOf(0,1)))
    println(missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))
    println(missingNumber(intArrayOf(1)))
    println(missingNumber(intArrayOf(1,2)))
    println(missingNumber(intArrayOf(1,2,3)))
}

fun missingNumber(nums: IntArray): Int {
    return (nums.size * (nums.size + 1) / 2) - nums.sum()
}