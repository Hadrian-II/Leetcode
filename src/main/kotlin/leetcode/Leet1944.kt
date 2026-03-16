package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(canSeePersonsCount(intArrayOf(10,6,8,5,11,9)))
    printIntArray(canSeePersonsCount(intArrayOf(5,1,2,3,10)))
}

fun canSeePersonsCount(heights: IntArray): IntArray {
    val answers = IntArray(heights.size)
    val right = mutableListOf<Int>()
    var i = heights.size -1
    while(i >= 0) {
        var sees = 0
        while (heights[i] > (right.lastOrNull() ?: Int.MAX_VALUE)) {
            right.removeLast()
            sees++
        }
        answers[i] = sees + if(right.isEmpty()) 0 else 1
        right.add(heights[i])
        i--
    }
    return answers
}