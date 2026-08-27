package leetcode

import kotlin.random.Random

class Solution398(nums: IntArray) {

    val map = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (i in nums.indices) {
            val num = nums[i]
            map.getOrPut(num) { mutableListOf() }.add(i)
        }
    }

    fun pick(target: Int): Int {
        val indices = map[target]!!
        return indices[Random.nextInt(indices.size)]
    }
}
