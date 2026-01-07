package leetcode

import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(maxArea(intArrayOf(1,1)))
    println(maxArea(intArrayOf(1,1,1,1,1,1,100000,100000,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)))
}

fun maxArea(height: IntArray): Int {
    var start = 0
    var end = height.lastIndex
    var currentArea = calcArea(height, start, end)

    while (start < end) {
        if (height[start] > height[end]) {
            end--
        } else {
            start++
        }
        val area = calcArea(height, start, end)
        if (area > currentArea) {
            currentArea = area
        }
    }
    return currentArea
}

private fun calcArea(height: IntArray, start: Int, end: Int): Int {
    return min(height[start], height[end]) * (end - start)
}