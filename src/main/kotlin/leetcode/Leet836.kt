package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(isRectangleOverlap(intArrayOf(0,0,2,2), intArrayOf(1,1,3,3)))
    println(isRectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(1,0,2,1)))
    println(isRectangleOverlap(intArrayOf(0,0,1,1), intArrayOf(2,2,3,3)))
    println(isRectangleOverlap(intArrayOf(7,8,13,15), intArrayOf(10,8,12,20)))
}

fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    return max(rec1[0], rec2[0]) < min(rec1[2], rec2[2]) &&
           max(rec1[1], rec2[1]) < min(rec1[3], rec2[3])
}