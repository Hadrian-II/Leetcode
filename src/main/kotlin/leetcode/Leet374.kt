package leetcode

import kotlin.time.measureTime

fun main() {
    //println(Solution374(4).guessNumber(100))
    //println(Solution374(845306345).guessNumber(2100000000))
    println(measureTime {  println(Solution374(1702766719).guessNumber(2126753390)) })
}

class Solution374 (val number: Int) {
    fun guess(num: Int): Int {
        return if (num == number) {
            0
        } else if (num > number) {
            -1
        } else {
            1
        }
    }

    fun guessNumber(n:Int):Int {
        var low = 0L
        var high = n.toLong()

        while(low <= high) {
            val mid = (high + low) / 2
            val res = guess(mid.toInt())

            if (res == 0) {
                return mid.toInt()
            } else if (res == 1) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return -1
    }
}