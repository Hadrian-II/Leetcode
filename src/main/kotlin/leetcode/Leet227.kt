package leetcode

fun main() {
    println(calculate("3+2*2"))
    println(calculate("3/2"))
    println(calculate("3+5/2"))
    println(calculate("0"))
    println(calculate("1 + 1"))
}

fun calculate(s: String): Int {
    val parsed = mutableListOf<Pair<Int, Char>>()
    var number: Int? = null

    for (c in s) {
        if (c.isDigit()) {
            if (number != null) {
                number *= 10
                number += c - '0'
            } else {
                number = c - '0'
            }
        } else {
            if (number != null) {
                parsed.add(Pair(number, ' '))
                number = null
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                parsed.add(Pair(0, c))
            }
        }
    }
    if (number != null) {
        parsed.add(Pair(number, ' '))
    }
    var i = 0
    while (i < parsed.size - 2) {
        val operator = parsed[i + 1].second
        if (operator == '/' || operator == '*') {
            if (operator == '/') {
                parsed[i] = Pair(parsed[i].first / parsed[i + 2].first, ' ')
            } else {
                parsed[i] = Pair(parsed[i].first * parsed[i + 2].first, ' ')
            }
            parsed.removeAt(i + 1)
            parsed.removeAt(i + 1)
        } else {
            i += 2
        }
    }

    i = 0
    var result = parsed[i].first
    while (i < parsed.size - 2) {
        if (parsed[i + 1].second == '+') {
            result += parsed[i + 2].first
        } else {
            result -= parsed[i + 2].first
        }
        i += 2
    }

    return result
}