package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(findErrorNums(intArrayOf(1,2,2,4)))
    printIntArray(findErrorNums(intArrayOf(1,1)))
}

fun findErrorNums(nums: IntArray): IntArray {
    val counts = IntArray(nums.size)
    for (num in nums) {
        counts[num - 1]++
    }
    var duplicate = -1
    var miss = -1
    for (i in counts.indices) {
        if (counts[i] == 0) {
            miss = i + 1
        } else if (counts[i] == 2) {
            duplicate = i + 1
        }
        if (duplicate != -1 && miss != -1) {
            return intArrayOf(duplicate, miss)
        }
    }
    throw RuntimeException("fail")
}