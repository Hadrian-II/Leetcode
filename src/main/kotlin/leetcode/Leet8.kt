package leetcode

fun main() {
    println(myAtoi("42"))
    println(myAtoi("-42"))
    println(myAtoi("1337c0d3"))
    println(myAtoi("0-1"))
    println(myAtoi("words and 987"))
    println(myAtoi("-91283472332"))
    println(myAtoi("+1"))
    println(myAtoi("  +  413"))
}

fun myAtoi(s: String): Int {
    val zeroCode = 48
    var result = 0
    var started = false
    var sign: Char? = null
    for (c in s) {
        if (c == ' ' && !started) {
            // ignore leading whitspace
        } else if (((c == '+' || c == '-') && sign == null) && !started) {
            sign = c
            started = true
        } else if (c.code in zeroCode..zeroCode+9) {
            val check = result
            result *= 10
            result += (c.code - zeroCode) * if (sign == '-') -1 else 1
            if (result / 10 != check) {
                return if (sign == '-') Int.MIN_VALUE else Int.MAX_VALUE
            }
            started = true
        } else {
            return result
        }
    }
    return result
}