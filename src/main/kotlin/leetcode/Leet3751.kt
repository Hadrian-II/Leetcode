package leetcode

import kotlin.math.max
import kotlin.time.measureTime

fun main() {
//    println(totalWaviness(120, 130))
//    println(totalWaviness(198, 202))
//    println(totalWaviness(4848, 4848))
//    println(totalWaviness(1000, 1000))
    println(measureTime {
        println(totalWaviness(1, 50000000))
    })
}

fun totalWaviness(num1: Int, num2: Int): Int {
    if (num2 < 100) {
        return 0
    }
    val map = IntArray(1000) { -1 }
    var result = 0
    for (n in max(100, num1) .. num2) {
        var number = n
        while (number > 99) {
            val check = number % 1000
            if (map[check] == -1) {
                map[check] = getWaviness(check)
            }
            result += map[check]
            number /= 10
        }
    }
    return result
}

fun getWaviness(num: Int): Int {
    val digits = ArrayList<Int>(3)
    var n = num
    for (i in 0..2) {
        digits.add(n % 10)
        n /= 10
    }
    return if ((digits[1] > digits[0] && digits[1] > digits[2]) ||
        (digits[1] < digits[0] && digits[1] < digits[2])) {
        1
    } else {
        0
    }
}