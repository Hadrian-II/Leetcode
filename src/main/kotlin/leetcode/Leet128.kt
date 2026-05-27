package leetcode

import kotlin.math.max

fun main() {
    println(longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
    println(longestConsecutive(intArrayOf(1,0,1,2)))
}

fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toSet()
    var max = 0

    for (num in numSet) {
        if (num - 1 !in numSet) {
            var current = 1
            var ncp = num + 1
            while (ncp in numSet) {
                ncp++
                current++
            }
            max = max(current, max)
        }
    }

    return max
}