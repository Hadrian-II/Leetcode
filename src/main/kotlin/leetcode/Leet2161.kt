package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(pivotArray(intArrayOf(9,12,5,10,14,3,10), 10))
    printIntArray(pivotArray(intArrayOf(-3,4,3,2), 2))
}

fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val smalls = mutableListOf<Int>()
    val pivots = mutableListOf<Int>()
    val bigs = mutableListOf<Int>()

    for (num in nums) {
        if (num < pivot) {
            smalls.add(num)
        } else if (num == pivot) {
            pivots.add(num)
        } else {
            bigs.add(num)
        }
    }
    return (smalls + pivots + bigs).toIntArray()
}