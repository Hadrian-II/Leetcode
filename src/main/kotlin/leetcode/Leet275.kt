package leetcode

import kotlin.math.max

fun main() {
    println(Solution275().hIndex(intArrayOf(0,1,3,5,6)))
    println(Solution275().hIndex(intArrayOf(1,2,100)))
    println(Solution275().hIndex(intArrayOf(0)))
    println(Solution275().hIndex(intArrayOf(0, 0)))
    println(Solution275().hIndex(intArrayOf(0, 1)))
}

class Solution275() {
    fun hIndex(citations: IntArray): Int {
        var low = 0
        var high = citations.lastIndex

        while (low <= high) {
            val mid = (low + high) / 2

            if (citations[mid] >= citations.size - mid) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return citations.size - low
    }
}