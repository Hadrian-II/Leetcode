package leetcode

import kotlin.math.max

fun main() {
    println(canJump(intArrayOf(2,3,1,1,4)))
    println(canJump(intArrayOf(3,2,1,0,4)))
}

fun canJump(nums: IntArray): Boolean {
    var reaches = 0
    for (i in nums.indices) {
        if (i > reaches) {
            return false
        } else if (reaches >= nums.size) {
            return true
        }
        reaches = max(reaches, i + nums[i])
    }
    return true
}