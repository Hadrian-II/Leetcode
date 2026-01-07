package leetcode

import kotlin.math.max

fun main() {
    println(longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2))                  // 6
    println(longestOnes(intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3))  // 10
    println(longestOnes(intArrayOf(0,0,0,1), 4))                                // 4
    println(longestOnes(intArrayOf(1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1), 8)) // 25
    println(longestOnes(intArrayOf(0,0,1,1,1,0,0), 0))                          // 3
    println(longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1), 0))                    // 4
}

fun longestOnes(nums: IntArray, k: Int) : Int {
    var max = 0
    var current = 0
    val replacedIndexes = Array(max(k, 1)) {0}
    var replaced = 0
    nums.mapIndexed { i, num ->
        if (num == 1) {
            current++
        } else {
            if (k == 0) {
                current = 0
            } else {
                if (replaced < k) {
                    current++
                } else {
                    current = i - replacedIndexes[replaced % k]
                }
                replacedIndexes[replaced % k] = i
                replaced++
            }
        }
        max = max(max, current)
    }
    return max
}