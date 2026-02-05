package leetcode

import java.util.PriorityQueue

fun main() {
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}

fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(compareByDescending { it })
    heap.addAll(stones.toList())

    while (heap.size > 1) {
        val result = heap.poll() - heap.poll()
        if (result > 0) {
            heap.add(result)
        }
    }

    return heap.lastOrNull() ?: 0
}