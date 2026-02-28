package leetcode

import kotlin.math.sqrt
import kotlin.time.measureTime

fun main() {
    println(judgeSquareSum(5))
    println(judgeSquareSum(3))
    println(judgeSquareSum(4))
    println(judgeSquareSum(0))
    println(measureTime {
        println(judgeSquareSum(2147483644))
    })
    println(judgeSquareSum(2147483600))
}

fun judgeSquareSum(c: Int): Boolean {
    var a = 0
    var b = sqrt(c.toDouble()).toInt()
    while (a <= b) {
        val sum = a * a + b * b
        if (sum == c) {
            return true
        } else if (sum !in 0..c) {
            b--
        } else {
            a++
        }
    }

    return false
}