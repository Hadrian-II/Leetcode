package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(Solution912().sortArray(intArrayOf(5,2,3,1)))
    printIntArray(Solution912().sortArray(intArrayOf(5,1,1,2,0,0)))
    printIntArray(Solution912().sortArray(intArrayOf(-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39)))
}

class Solution912 {
    lateinit var numbers: IntArray
    fun sortArray(nums: IntArray): IntArray {
        numbers = nums
        var i = numbers.size / 2
        while (i >= 0) {
            heapify(i--, numbers.size)
        }

        i = numbers.size - 1
        while (i > 0) {
            val last = numbers[i]
            numbers[i] = numbers[0]
            numbers[0] = last
            heapify(0, i--)
        }

        return numbers
    }

    fun heapify(parentId: Int, end: Int) {
        val leftId = parentId * 2 + 1
        val rightId = parentId * 2 + 2
        val parent = numbers[parentId]
        val left = if (leftId < end) numbers[leftId] else Int.MIN_VALUE
        val right = if (rightId < end) numbers[rightId] else Int.MIN_VALUE
        if (left > parent && left > right) {
            numbers[parentId] = left
            numbers[leftId] = parent
            heapify(leftId, end)
        } else if (right > parent) {
            numbers[parentId] = right
            numbers [rightId] = parent
            heapify(rightId, end)
        }
    }
}