package leetcode

import kotlin.random.Random

class Solution384(val nums: IntArray) {
    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val random = mutableListOf<Int>()
        val numbers = nums.toMutableList()
        while (numbers.isNotEmpty()) {
            random.add(numbers.removeAt(Random.nextInt(numbers.size)))
        }
        return random.toIntArray()
    }
}
