package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(plusOne(intArrayOf(1,2,3)))
    printIntArray(plusOne(intArrayOf(4,3,2,1)))
    printIntArray(plusOne(intArrayOf(9)))
}

fun plusOne(digits: IntArray): IntArray {
    val result = ArrayList<Int>()
    var takeover = 1
    for (i in digits.indices.reversed()) {
        val sum = digits[i] + takeover
        if (sum > 9) {
            result.add(sum - 10)
            takeover = 1
        } else {
            result.add(sum)
            takeover = 0
        }
    }
    if (takeover == 1) {
        result.add(takeover)
    }
    return result.reversed().toIntArray()
}