package leetcode

import kotlin.collections.lastIndex
import kotlin.time.measureTime

fun main() {
    println(Solution790().numTilings((3)))
    println(Solution790().numTilings((1)))
    println(measureTime {  println(Solution790().numTilings((1000))) })
}

class Solution790 {
    fun numTilings(n: Int): Int {
        var status = longArrayOf(1,0,0)
        val divisor = 1000000007
        for (i in 0..<n) {
            status = longArrayOf(
                (status[0] + status[2]) % divisor,
                (status[0] * 2 + status[1]) % divisor,
                (status[0] + status[1]) % divisor
            )
        }
        return status[0].toInt()
    }

    /*
    empty + | -> +1 empty
    empty + = -> +2 empty
    empty + < ->  +1 one * 2
    one + - -> +1 one
    one +< -> +2 empty
     */
}