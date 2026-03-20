package leetcode

import helpers.printIntArray
import kotlin.math.max
import kotlin.math.min

fun main() {
    printIntArray(searchRange(intArrayOf(5,7,7,8,8,10), 8))
    printIntArray(searchRange(intArrayOf(5,7,7,8,8,10), 6))
    printIntArray(searchRange(intArrayOf(), 0))
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf(-1, -1)
    }
    var low = 0
    var high = nums.lastIndex
    var first = Int.MAX_VALUE

    while(low <= high) {
        val mid = (low + high) / 2
        if (nums[mid] >= target) {
            if (nums[mid] == target) {
                first = min(first, mid)
            }
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    var last = -1

    low = 0
    high = nums.lastIndex
    while(low <= high) {
        val mid = (low + high) / 2
        if (nums[mid] <= target) {
            if (nums[mid] == target) {
                last = max(last, mid)
            }
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return intArrayOf(if (first == Int.MAX_VALUE) -1 else first, last)
}