package leetcode

import java.util.PriorityQueue

fun main() {

}

class SmallestInfiniteSet() {
    var smallest = 1
    var backAdded = PriorityQueue<Int>()

    fun popSmallest(): Int {
        if (backAdded.size > 0) {
            return backAdded.poll()
        }
        smallest ++
        return smallest - 1
    }

    fun addBack(num: Int) {
        if (num < smallest && num !in backAdded) {
            backAdded.add(num)
        }
    }
}