package leetcode

import helpers.printIntArray
import java.util.PriorityQueue

fun main() {
    printIntArray(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3))
    printIntArray(maxSlidingWindow(intArrayOf(1), 1))
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    val diff = k - 1
    val result = IntArray(nums.size - diff)
    val inWindow = sortedSetOf<Int>()
    for (i in nums.indices) {
        val num = nums[i]
        if (num in map) {
            map[num] = map[num]!! + 1
        } else {
            map[num] = 1
            inWindow.add(num)
        }

        if (i >= k) {
            val remove = nums[i - k]
            if (map[remove]!! > 1) {
                map[remove] = map[remove]!! - 1
            } else {
                map.remove(remove)
                inWindow.remove(remove)
            }
        }
        if (i >= diff) {
            result[i - diff] = inWindow.last()
        }
    }
    return result
}