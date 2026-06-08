package leetcode

import kotlin.math.abs

fun main() {
    println(fractionToDecimal(1,2))
    println(fractionToDecimal(2,1))
    println(fractionToDecimal(4,333))
    println(fractionToDecimal(10,3))
    println(fractionToDecimal(-50,8))
    println(fractionToDecimal(1, -1))
    println(fractionToDecimal(-22, -2))
    println(fractionToDecimal(7, -12))
    println(fractionToDecimal(-1, Int.MIN_VALUE))
}

fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) {
        return "0"
    }
    val result = StringBuilder()
    var current = abs(numerator.toLong())
    val deno = abs(denominator.toLong())
    if (numerator < 0 != denominator < 0) {
        result.append('-')
    }

    if (current >= deno) {
        val before = current / deno
        current -= before * deno
        result.append(before)
    } else {
        result.append('0')
    }
    current *= 10

    if (current == 0L) {
        return result.toString()
    }
    result.append('.')

    val visited = mutableSetOf<Long>()

    while (current != 0L) {
        val digit = if (current < deno) {
            0
        } else {
            current / deno
        }

        result.append(digit)
        current -= digit * deno
        current *= 10
        if (digit in visited) {
            result.insert(visited.indexOf(digit) + result.indexOf('.') + 1, '(')
            result.deleteCharAt(result.lastIndex)
            result.append(')')
            return result.toString()
        } else {
            visited.add(digit)
        }
    }

    return result.toString()
}