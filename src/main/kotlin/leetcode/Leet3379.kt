package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(constructTransformedArray(intArrayOf(3,-2,1,1)))
    printIntArray(constructTransformedArray(intArrayOf(-1,4,-1)))
}

fun constructTransformedArray(nums: IntArray): IntArray {
    val bigNr = 400 - (400 % nums.size)
    return nums.mapIndexed { i, num ->
        if (num > 0) {
            nums[(i + num) % nums.size]
        } else if (num < 0) {
            nums[(i + num + bigNr) % nums.size]
        } else {
            num
        }
    }.toIntArray()
}