package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(countBits(2))
    printIntArray(countBits(5))
    printIntArray(countBits(32))
}

fun countBits(n: Int): IntArray {
    val answer = IntArray(n + 1)
    var bit = 1
    for (i in 1..n) {
        if (bit * 2 == i) {
            bit = i
        }
        answer[i] = answer[i - bit] + 1
    }
    return answer
}