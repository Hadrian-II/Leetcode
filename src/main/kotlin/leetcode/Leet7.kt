package leetcode

fun main() {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))
    println(reverse(1534236469))
}

fun reverse(x: Int): Int {
    val negative = x < 0

    var buf = x
    if (negative) {
        buf *= -1
    }
    val numbers = ArrayList<Int>()
    while (buf != 0) {
        numbers.add(buf % 10)
        buf /= 10
    }
    var result = 0
    val needsCheck = numbers.size == 10
    if (needsCheck) {
        for (number in numbers) {
            buf = result * 10
            buf += number
            if (buf / 10 != result) {
                return 0
            }
            result = buf
        }
    } else {
        for (number in numbers) {
            result *= 10
            result += number
        }
    }
    if (negative) {
        result *= -1
    }
    return result
}