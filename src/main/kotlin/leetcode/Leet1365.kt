package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(smallerNumbersThanCurrent(intArrayOf(6,5,4,8)))
    printIntArray(smallerNumbersThanCurrent(intArrayOf(7,7,7,7)))
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val frequency = IntArray(101)
    for (num in nums) {
        frequency[num]++
    }
    val result = HashMap<Int, Int>()
    var count = 0
    for (i in frequency.indices) {
        if (frequency[i] != 0) {
            result[i] = count
            count += frequency[i]
        }
    }
    val resultArray = IntArray(nums.size)
    for (i in nums.indices) {
        resultArray[i] = result[nums[i]]!!
    }
    return resultArray
}