package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(Solution167().twoSum(intArrayOf(2,7,11,15), 9))
    printIntArray(Solution167().twoSum(intArrayOf(2,3,4), 6))
    printIntArray(Solution167().twoSum(intArrayOf(-1,0), -1))
}

class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in 0..<numbers.lastIndex) {
            val current = numbers[i]
            val search = target - current
            if (search == current) {
                return if (numbers[i + 1] == search) {
                    intArrayOf(i + 1, i + 2)
                } else {
                    intArrayOf(i, i + 1)
                }
            }

            var start = 0
            var end = numbers.lastIndex
            while (start <= end) {
                val mid = (start + end) / 2

                if (numbers[mid] == search) {
                    return if (mid > i) {
                        intArrayOf(i + 1, mid + 1)
                    } else {
                        intArrayOf(mid + 1, i + 1)
                    }
                } else if (numbers[mid] > search) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }
        }

        return IntArray(0)
    }
}