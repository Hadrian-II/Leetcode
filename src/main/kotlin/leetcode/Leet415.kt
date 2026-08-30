package leetcode

import kotlin.math.max
import kotlin.random.Random
import kotlin.time.measureTime

fun main() {
    println(addStrings("11", "123"))
    println(addStrings("456", "77"))
    println(addStrings("0", "0"))
    println(addStrings("1", "9"))
    val n1 = randNr()
    val n2 = randNr()
    println(measureTime { addStrings(n1, n2) })
}

fun randNr(): String {
    val digits = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    return CharArray(10000) { digits[Random.nextInt(9)] }.concatToString()
}

fun addStrings(num1: String, num2: String): String {
    val last = max(num1.length, num2.length)
    val output = StringBuilder(last + 1)

    var carry = 0
    val size1 = num1.lastIndex
    val size2 = num2.lastIndex
    for (i in 0 until last) {
        val sum = if (i <= size1) {
            num1[size1 - i].digitToInt()
        } else {
            0
        } + if (i <= size2) {
            num2[size2 - i].digitToInt()
        } else {
            0
        } + carry
        output.append((sum % 10).digitToChar())
        carry = sum / 10
    }

    if (carry > 0) {
        output.append(carry)
    }

    return output.reversed().toString()
}