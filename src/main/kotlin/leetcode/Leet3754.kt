package leetcode

fun main() {
    println(sumAndMultiply(10203004))
    println(sumAndMultiply(1000))
}

fun sumAndMultiply(n: Int): Long {
    val digits = mutableListOf<Int>()
    var nr = n
    var sum = 0
    while (nr > 0) {
        val digit = nr % 10
        if (digit != 0) {
            digits.add(digit)
            sum += digit
        }
        nr /= 10
    }
    nr = 0
    for (i in digits.lastIndex downTo 0) {
        val digit = digits[i]
        nr *= 10
        nr += digit
    }
    return nr.toLong() * sum
}