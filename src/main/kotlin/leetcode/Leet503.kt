package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(nextGreaterElements(intArrayOf(1,2,1)))
    printIntArray(nextGreaterElements(intArrayOf(1,2,3,4,3)))
    printIntArray(nextGreaterElements(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    printIntArray(nextGreaterElements(intArrayOf(-2,-1)))
}

fun nextGreaterElements(nums: IntArray): IntArray {
    if (nums.size == 1) {
        return intArrayOf(-1)
    }
    var max = Int.MIN_VALUE
    var maxIx = 0

    nums.forEachIndexed { i, num ->
        if (num > max) {
            max = num
            maxIx = i
        }
    }

    val size = nums.size
    val result = IntArray(size)
    val maxStack = IntArray(size)
    maxStack[0] = max
    var sPtr = 0
    for (i in maxIx + nums.lastIndex downTo maxIx) {
        val xi = i % size
        val num = nums[xi]
        var possible = maxStack[sPtr]
        while (sPtr > 0 && possible <= num) {
            possible = maxStack[--sPtr]
        }
        result[xi] = if (num == max) -1 else possible
        maxStack[++sPtr] = num
    }
    return result
}