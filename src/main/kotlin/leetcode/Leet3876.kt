package leetcode

import kotlin.math.min

fun main() {
    println(uniformArray(intArrayOf(1,4,7)))
    println(uniformArray(intArrayOf(2,3)))
    println(uniformArray(intArrayOf(13, 10)))
    println(uniformArray(intArrayOf(12, 9)))
    println(uniformArray(intArrayOf(4, 6)))
}

fun uniformArray(nums1: IntArray): Boolean {
    var minOdd = Int.MAX_VALUE
    var minEven = Int.MAX_VALUE

    for (num in nums1) {
        if (num % 2 == 1) {
            minOdd = min(minOdd, num)
        } else {
            minEven = min(minEven, num)
        }
    }

    return minOdd == Int.MAX_VALUE || minEven == Int.MAX_VALUE || minOdd < minEven
}