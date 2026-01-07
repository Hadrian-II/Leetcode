package leetcode

import java.util.PriorityQueue

fun main() {
    println(maxScore(intArrayOf(1,3,3,2), intArrayOf(2,1,3,4), 3))
    println(maxScore(intArrayOf(4,2,3,1,1), intArrayOf(7,5,10,9,6), 1))
}

fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val order = nums2.mapIndexed { i, it -> Pair(i, it) }.sortedByDescending { it.second }.map { it.first }
    val usedElements = PriorityQueue<Long>()
    var currentScore = -1L
    var currentMult = -1L
    for (i in order) {
        if (usedElements.size < k) {
            usedElements.add(nums1[i].toLong())
            if (usedElements.size == k) {
                currentMult = nums2[i].toLong()
                currentScore = usedElements.reduce { acc, i -> acc + i } * currentMult
            }
        } else {
            val newMax = ((currentScore / currentMult - usedElements.peek()) + nums1[i]) * nums2[i]
            if (currentScore < newMax) {
                currentScore = newMax
                currentMult = nums2[i].toLong()
                usedElements.remove()
                usedElements.add(nums1[i].toLong())
            }
        }
    }
    return currentScore
}