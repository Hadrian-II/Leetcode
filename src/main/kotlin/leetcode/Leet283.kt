package leetcode

import helpers.printIntArray

fun main() {
    moveZeroes(intArrayOf(0,1,0,3,12))
    moveZeroes(intArrayOf(0))
    moveZeroes(intArrayOf(0,0,0,0,1,2,3,4,5))
}

fun moveZeroes(nums: IntArray): Unit {
    var write = 0
    var zeroes = 0
    for (i in nums.indices) {
        if (nums[i] == 0) {
            zeroes += 1
        } else {
            if (zeroes > 0) {
                nums[write] = nums[i]
            }
            write += 1
        }
    }
    for (i in 1..zeroes) {
        nums[nums.size - i] = 0
    }
    printIntArray(nums)
}