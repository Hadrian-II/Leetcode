package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(getConcatenation(intArrayOf(1,2,1)))
    printIntArray(getConcatenation(intArrayOf(1,3,2,1)))
}

fun getConcatenation(nums: IntArray): IntArray {
    return nums + nums
}