package leetcode

import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    println(maxScore(intArrayOf(1,3,3,2), intArrayOf(2,1,3,4), 3))
    println(maxScore(intArrayOf(4,2,3,1,1), intArrayOf(7,5,10,9,6), 1))
    println(maxScore(intArrayOf(2,1,14,12), intArrayOf(11,7,13,6), 3))
}

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val elements = PriorityQueue<Pair<Long, Long>>(compareBy { it.second })
    val maxList = nums1.map { it.toLong() }.sortedDescending().toMutableList()
    for (i in nums1.indices) {
        elements.add(Pair(nums1[i].toLong(), nums2[i].toLong()))
    }
    var max = 0L
    while (elements.size >= k) {
        val current = elements.poll()
        maxList.remove(current.first)
        val sum = current.second * (current.first + maxList.take(k - 1).sum())
        max = max(max, sum)
    }
    return max
}