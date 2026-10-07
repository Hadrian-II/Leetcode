package leetcode

import helpers.printIntArray
import kotlin.math.abs

fun main() {
    printIntArray(nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)))
    printIntArray(nextGreaterElement(intArrayOf(2,4), intArrayOf(1,2,3,4)))
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val nextBigMap = mutableMapOf<Int, Int>()
    for (i2 in nums2.lastIndex downTo 0) {
        val current = nums2[i2]
        while (stack.isNotEmpty() && stack.first() < current) {
            stack.removeFirst()
        }
        nextBigMap[current] = if (stack.isEmpty()) -1 else stack.first()
        stack.addFirst(current)
    }

    val result = IntArray(nums1.size)
    for (i in nums1.indices) {
        result[i] = nextBigMap[nums1[i]]!!
    }
    return result
}