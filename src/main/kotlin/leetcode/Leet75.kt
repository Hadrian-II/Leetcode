package leetcode

import helpers.printIntArray

fun main() {
    val i1 = intArrayOf(2,0,2,1,1,0)
    sortColors(i1)
    printIntArray(i1)

    val i2 = intArrayOf(2,0,1)
    sortColors(i2)
    printIntArray(i2)
}

fun sortColors(nums: IntArray): Unit {
    var blueCount = 0
    var whiteCount = 0
    var redCount = 0
    for (num in nums) {
        when(num) {
            0 -> redCount++
            1 -> whiteCount++
            2 -> blueCount++
        }
    }
    var i = 0
    for(x in 0..<redCount) {
        nums[i++] = 0
    }
    for(x in 0..<whiteCount) {
        nums[i++] = 1
    }
    for(x in 0..<blueCount) {
        nums[i++] = 2
    }
}