package leetcode

import java.util.PriorityQueue

fun main() {
    println(kSmallestPairs(intArrayOf(1,7,11), intArrayOf(2,4,6), 3))
    println(kSmallestPairs(intArrayOf(1,1,2), intArrayOf(1,2,3), 2))
}

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val heap = PriorityQueue<List<Int>>(compareByDescending { it[0] + it[1] })
    var biggest = Int.MAX_VALUE
    for (n1 in nums1) {
        for (n2 in nums2) {
            if (heap.size < k) {
                heap.add(listOf(n1, n2))
                if (heap.size == k) {
                    biggest = heap.peek().sum()
                }
            } else {
                if (biggest > n1 + n2) {
                    heap.poll()
                    heap.add(listOf(n1, n2))
                    biggest = heap.peek().sum()
                } else {
                    break
                }
            }
        }
    }
    return heap.toList()
}