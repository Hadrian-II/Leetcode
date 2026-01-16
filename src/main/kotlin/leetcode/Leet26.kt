package leetcode

import helpers.printIntArray

fun main() {
    println(removeDuplicates(intArrayOf(1,1,2)))
    println(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
}

fun removeDuplicates(nums: IntArray): Int {
    var insert = 0
    var last = -200
    for (num in nums) {
        if (num != last) {
            nums[insert] = num
            last = num
            insert++
        }
    }
    return insert
}