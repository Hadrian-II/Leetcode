package leetcode

import kotlin.math.max

fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1)))
    println(findMaxConsecutiveOnes(intArrayOf(1,0,1,1,0,1)))
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var consecutive = 0
    var max = 0
    for (num in nums) {
        if (num == 1) {
            consecutive++
        } else {
            max = max(consecutive, max)
            consecutive = 0
        }
    }
    return max(max, consecutive)
}