package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
    println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2))
    println(computeArea(-2, -2, -1, -1, 1, 1, 2, 2))
    println(computeArea(-2, -2, 2, 2, -4, -4, -3, -3))
}

fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    val squares = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)
    return if (ax2 > bx1 && ay2 > by1 && bx2 > ax1 && by2 > ay1) {
        squares - (min(ax2, bx2) - max(ax1, bx1)) * (min(ay2, by2) - max(ay1, by1))
    } else {
        squares
    }
}