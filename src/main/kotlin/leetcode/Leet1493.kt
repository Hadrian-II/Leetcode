package leetcode

import kotlin.math.max

fun main() {
    println(longestSubarray(intArrayOf(1,1,0,1)))
    println(longestSubarray(intArrayOf(0,1,1,1,0,1,1,0,1)))
    println(longestSubarray(intArrayOf(1,1,1)))
}

fun longestSubarray(nums: IntArray): Int {
    var current = nums[0]
    var sum = 0
    val condensed = ArrayList<Int>()
    for (num in nums) {
        if (num == current) {
            sum++
        } else {
            condensed.add(if (current == 1) sum else -sum)
            current = num
            sum = 1
        }
    }
    condensed.add(if (current == 1) sum else -sum)
    return if (condensed.size == 1) {
        max(condensed[0] - 1, 0)
    } else {
        var max = 0
        condensed.mapIndexed { i, c ->
            if (c > 0) {
                max = max(c, max)
            } else if (c == -1 && i > 0 && i < condensed.lastIndex) {
                max = max(max, condensed[i - 1] + condensed[i + 1])
            }
        }
        max
    }
}