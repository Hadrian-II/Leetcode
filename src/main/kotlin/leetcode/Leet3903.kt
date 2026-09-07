package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(firstStableIndex(intArrayOf(5,0,1,4), 3))
    println(firstStableIndex(intArrayOf(3,2,1), 1))
    println(firstStableIndex(intArrayOf(0), 0))
}

fun firstStableIndex(nums: IntArray, k: Int): Int {
    var min = Int.MAX_VALUE
    val mins = IntArray(nums.size)

    for (i in nums.lastIndex downTo 0) {
        min = min(min, nums[i])
        mins[i] = min
    }

    var max = 0

    for (i in nums.indices) {
        max = max(nums[i], max)
        if (max - mins[i] <= k) {
            return i
        }
    }

    return -1
}