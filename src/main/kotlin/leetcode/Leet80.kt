package leetcode

import helpers.printIntArray

fun main() {
    val i1 = intArrayOf(1,1,1,2,2,3)
    println(Solution80().removeDuplicates(i1))
    printIntArray(i1)

    val i2 = intArrayOf(0,0,1,1,1,1,2,3,3)
    println(Solution80().removeDuplicates(i2))
    printIntArray(i2)
}

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        var current = nums[0]
        var cCount = 1
        var write = 1
        var i = 1
        while (i < nums.size) {
            val num = nums[i]
            if (num == current) {
                cCount++
            } else {
                current = num
                cCount = 1
            }
            if (cCount < 3) {
                nums[write] = num
                write++
            }
            i++
        }
        return write
    }
}