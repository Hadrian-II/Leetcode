package leetcode

import kotlin.math.max

fun main() {
    println(largestInteger(intArrayOf(3,9,2,1,7), 3))
    println(largestInteger(intArrayOf(3,9,7,2,1,7), 4))
    println(largestInteger(intArrayOf(0,0), 3))
    println(largestInteger(intArrayOf(3,1,7,10,0), 1))
}

fun largestInteger(nums: IntArray, k: Int): Int {
    val first = nums.first()
    if (nums.size == 1) {
        return first
    }
    if (k == nums.size) {
        return nums.max()
    }
    if (k == 1) {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }
        var result = -1
        for (entry in map) {
            if (entry.value == 1) {
                result = max(result, entry.key)
            }
        }
        return result
    }
    val last = nums.last()
    if (first == last) {
        return -1
    }
    var doubleFirst = false
    var doubleLast = false
    var i = 1
    while (i < nums.lastIndex) {
        val num = nums[i]
        if (num == first) {
            doubleFirst = true
        } else if (num == last) {
            doubleLast = true
        }
        if (doubleFirst && doubleLast) {
            return -1
        }
        i++
    }
    return if (doubleFirst) {
        last
    } else if (doubleLast) {
        first
    } else {
        max(last, first)
    }
}