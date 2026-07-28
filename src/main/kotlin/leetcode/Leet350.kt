package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(intersect(intArrayOf(1,2,2,1), intArrayOf(2,2)))
    printIntArray(intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)))
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val numMap = mutableMapOf<Int, Int>()
    for (num in nums1) {
        numMap[num] = (numMap[num] ?: 0) + 1
    }
    val result = mutableListOf<Int>()
    for (num in nums2) {
        if (num in numMap) {
            result.add(num)
            val curr = numMap[num]!!
            if (curr == 1) {
                numMap.remove(num)
            } else {
                numMap[num] = curr - 1
            }
        }
    }
    return result.toIntArray()
}