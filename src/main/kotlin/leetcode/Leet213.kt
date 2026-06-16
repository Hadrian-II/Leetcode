package leetcode

import kotlin.math.max

fun main() {
    println(Solution213().rob(intArrayOf(2,3,2)))
    println(Solution213().rob(intArrayOf(1,2,3,1)))
    println(Solution213().rob(intArrayOf(1,2,3)))
}

class Solution213 {
    lateinit var nums: IntArray
    lateinit var memo: IntArray
    fun rob(nums: IntArray): Int {
        if (nums.size < 4) {
            return nums.max()
        }
        this.nums = nums
        this.memo = IntArray(nums.size) { -1 }
        memo[0] = nums[0]
        memo[1] = max(nums[0], nums[1])
        val last = rob(nums.lastIndex - 1)
        this.memo = IntArray(nums.size) { -1 }
        memo[1] = nums[1]
        memo[2] = max(nums[1], nums[2])
        val first = rob(nums.lastIndex)
        return max(last, first)
    }

    fun rob(i: Int): Int {
        if (memo[i] == -1) {
            memo[i] = max(rob(i - 1), nums[i] + rob(i - 2))
        }
        return memo[i]
    }
}