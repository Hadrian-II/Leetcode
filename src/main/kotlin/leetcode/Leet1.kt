package leetcode

import kotlin.math.abs
import kotlin.math.max

fun main () {
    val r1 = twoSum(intArrayOf(2,7,11,15), 9)  // [0,1]
    val r2 = twoSum(intArrayOf(3,2,4), 6)      // [1,2]
    val r3 = twoSum(intArrayOf(3,3), 6)        // [0,1]
    val r4 = twoSum(intArrayOf(0,4,3,0), 0)    // [0,3]
    val blah = 4
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in 0..<nums.size) {
        val diff = target - nums[i]
        if (diff in map) {
            return intArrayOf(map[diff]!!, i)
        } else {
            map[nums[i]] = i
        }
    }
    return intArrayOf()
}