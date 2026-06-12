package leetcode

import kotlin.math.min

fun main() {
    println(minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
    println(minSubArrayLen(4, intArrayOf(1,4,4)))
    println(minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1)))

}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var start = 0
    var current = 0
    var result = Int.MAX_VALUE

    for (i in nums.indices) {
        current += nums[i]
        while (current >= target) {
            result = min(result, i - start + 1)
            current -= nums[start]
            start++
        }
    }

    return if (result == Int.MAX_VALUE) 0 else result
}