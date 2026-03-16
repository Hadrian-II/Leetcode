package leetcode

import helpers.printIntArray

fun main() {
    printIntArray( productExceptSelf(intArrayOf(1,2,3,4)))     // [24,12,8,6]
    printIntArray(productExceptSelf(intArrayOf(-1,1,0,-3,3)))  // [0,0,9,0,0]
}

fun productExceptSelf(nums: IntArray): IntArray {
    val pre = Array(nums.size) { 0 }
    var current = 1
    for (i in nums.indices) {
        pre[i] = current
        current *= nums[i]
    }
    current = 1
    for (i in nums.indices.reversed())  {
        val cbuffer = current
        current *= nums[i]
        nums[i] = cbuffer * pre[i]
    }
    return nums
}