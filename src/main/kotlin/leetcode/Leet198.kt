package leetcode

import kotlin.math.max
import kotlin.time.measureTime

fun main() {
    println(Solution198().rob(intArrayOf(1,2,3,1)))
    println(Solution198().rob(intArrayOf(2,7,9,3,1)))
    println(measureTime {  println(Solution198().rob(intArrayOf(114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240))) })
}

class Solution198 {
    lateinit var nums: IntArray
    val memo = HashMap<Int, Int>()
    fun rob(nums: IntArray): Int {
        this.nums = nums
        return rob(0)
    }

    fun rob(i: Int): Int {
        return memo.getOrPut(i) {
            if (i > nums.lastIndex) {
                0
            } else if (i == nums.lastIndex) {
                nums[nums.lastIndex]
            } else {
                max(rob(i + 1), nums[i] + rob(i + 2))
            }
        }
    }
}