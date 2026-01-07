package leetcode

import kotlin.math.max

fun main() {
    println(largestAltitude(intArrayOf(-5,1,5,0,-7)))
    println(largestAltitude(intArrayOf(-4,-3,-2,-1,4,3,2)))
}

fun largestAltitude(gain: IntArray): Int {
    var current = 0
    var max = 0
    for (g in gain) {
        current += g
        max = max(max, current)
    }
    return max
}