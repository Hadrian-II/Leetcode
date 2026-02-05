package leetcode

import java.util.PriorityQueue

fun main() {
    //tfttf
    println(isPossible(intArrayOf(9,3,5)))
    println(isPossible(intArrayOf(1,1,1,2)))
    println(isPossible(intArrayOf(8, 5)))
    println(isPossible(intArrayOf(1, 1000000000)))
    println(isPossible(intArrayOf(1000000000,1000000000,1000000000,1000000000,1000000000,294967297)))
}

fun isPossible(target: IntArray): Boolean {
    val heap = PriorityQueue<Long>(compareByDescending { it })
    val sizel = target.size.toLong()
    heap.addAll(target.map { it.toLong() })

    if (target.size == 1) {
        return target[0] == 1
    }

    var sum = heap.sum().toLong()
    while (true) {
        if (sum == sizel) {
            return true
        }
        val current = heap.poll()
        sum -= current
        val over = current % sum
        if (over < 1 || over == current) {
            return sum == 1L
        } else {
            heap.add(over)
            sum += over
        }
    }
}