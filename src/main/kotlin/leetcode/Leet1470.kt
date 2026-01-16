package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(shuffle(intArrayOf(2,5,1,3,4,7), 3))
    printIntArray(shuffle(intArrayOf(1,2,3,4,4,3,2,1), 4))
    printIntArray(shuffle(intArrayOf(1,1,2,2), 2))
}

fun shuffle(nums: IntArray, n: Int): IntArray {
    val result = IntArray(nums.size)
    var i = 0
    while (i < n) {
        var i2 = i * 2
        result[i2] =  nums[i]
        result[++i2] = nums[i + n]
        i++
    }
    return result
}