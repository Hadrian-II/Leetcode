package leetcode

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(largestRectangleArea(intArrayOf(2,1,5,6,2,3)))  // 10
    println(largestRectangleArea(intArrayOf(2,4))) // 4
    println(largestRectangleArea(intArrayOf(1,1))) // 2
    println(largestRectangleArea(intArrayOf(2,1,2))) // 3
}

fun largestRectangleArea(heights: IntArray): Int {
    val possibles = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })
    var max = 0
    heights.forEachIndexed { i, height ->
        max = max(max, height)

        for (possible in possibles) {
            max = max(max, min(possible.first, height) * (1 + i - possible.second))
        }

        var removed = Int.MAX_VALUE
        while (possibles.isNotEmpty() && possibles.peek().first  > height) {
            removed = possibles.poll().second
        }

        if (possibles.isEmpty() || possibles.peek().first < height) {
            possibles.add(Pair(height, min(removed, i)))
        }
    }
    return max
}