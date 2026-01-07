package leetcode

import java.util.PriorityQueue

fun main() {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
    println(findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val bigs = PriorityQueue<Int>()
    for (num in nums) {
        if (bigs.size < k) {
            bigs.add(num)
        } else if (num > bigs.peek()) {
            bigs.add(num)
            bigs.remove()
        }
    }
    return bigs.min()
}