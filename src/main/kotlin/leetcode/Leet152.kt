package leetcode

import kotlin.math.max

fun main() {
    println(maxProduct(intArrayOf(2,3,-2,4)))
    println(maxProduct(intArrayOf(-2,0,-1)))
    println(maxProduct(intArrayOf(-3,-1,-1)))
    println(maxProduct(intArrayOf(0, 2)))
    println(maxProduct(intArrayOf(-2, 0)))
    println(maxProduct(intArrayOf(0,0,0)))
}

fun maxProduct(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    var max = nums[0]
    val n = mutableListOf<Int>()
    for (num in nums) {
        if (num == 0) {
            max = max(0, max)
            if (n.isNotEmpty()) {
                max = max(max, arrayProduct(n))
                n.clear()
            }
        } else {
            n.add(num)
        }
    }
    if (n.isNotEmpty()) {
        max = max(max, arrayProduct(n))
    }
    return max
}

fun arrayProduct(nums: List<Int>): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    val negatives = nums.count { it < 0 }
    var maxMult = nums.reduce { acc, i -> acc * i }
    if (negatives % 2 == 0) {
        return maxMult
    }
    var max = nums[0]
    var current = 1
    var i = 0
    while (i < nums.size) {
        current *= nums[i]
        maxMult /= nums[i]
        max = max(max, maxMult)
        max = max(max, current)
        i++

    }
    return max
}