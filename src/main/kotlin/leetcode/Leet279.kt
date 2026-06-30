package leetcode

import kotlin.math.sqrt
import kotlin.time.measureTime

fun main() {
    println(Solution279().numSquares(12))
    println(Solution279().numSquares(13))
    println(Solution279().numSquares(192))
    println(measureTime {
        println(Solution279().numSquares(6730))
    })
}

class Solution279 {
    val memo = HashMap<Pair<Int, Int>, Int>()

    fun numSquares(n: Int): Int {
        val res = findResult(n, sqrt(n.toDouble()).toInt())
        return res
    }

    fun findResult(leftover: Int, size: Int): Int {
        return memo.getOrPut(Pair(leftover, size)) {
            calculateResult(leftover, size)
        }
    }

    fun calculateResult(leftover: Int, size: Int): Int {
        if (size == 1) {
            return leftover
        }

        val currentSquare = size * size
        val amount = leftover / currentSquare
        return if (amount > 0) {
            minOf(findResult(leftover, size - 1),
                  amount + findResult(leftover - amount * currentSquare, size - 1),
                  amount - 1 + findResult(leftover - (amount - 1) * currentSquare, size - 1))
        } else {
            findResult(leftover, size - 1)
        }
    }
}