package leetcode

import kotlin.math.abs

fun main() {
    println(Solution494().findTargetSumWays(intArrayOf(1,1,1,1,1), 3))
    println(Solution494().findTargetSumWays(intArrayOf(1,1,1), 1))
    println(Solution494().findTargetSumWays(intArrayOf(1), 1))
}

class Solution494 {
    val memo = mutableMapOf<Pair<Int, Int>, Int>()

    lateinit var nums: IntArray

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        this.nums = nums

        return findSumWays(0,target)
    }

    fun findSumWays(index: Int, remaining: Int): Int {
        return memo.getOrPut(Pair(index, remaining)) {
            if (index == nums.size) {
                if (remaining == 0) 1 else 0
            } else {
                val num = nums[index]
                findSumWays(index + 1, remaining + num) + findSumWays(index + 1, remaining - num)
            }
        }
    }
}