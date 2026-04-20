package leetcode

import kotlin.math.max

fun main() {
    println(addBinary("11", "1"))
    println(addBinary("1010", "1011"))
}

fun addBinary(a: String, b: String): String {
    val result = StringBuilder()
    var carry = 0
    val size = max(a.length, b.length)

    for (i in 1..size) {
        val sum = (if (i <= a.length && a[a.length - i] == '1') 1 else 0) +
                  (if (i <= b.length && b[b.length - i] == '1')  1 else 0) +
                  carry

        carry = if (sum >= 2) 1 else 0
        result.append(if (sum % 2 == 1) '1' else '0')
    }
    if (carry == 1) {
        result.append('1')
    }


    return result.reverse().toString()
}