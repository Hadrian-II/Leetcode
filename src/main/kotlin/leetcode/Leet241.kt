package leetcode

fun main() {
    println(Solution241().diffWaysToCompute("2-1-1"))
    println(Solution241().diffWaysToCompute("2*3-4*5"))
}

class Solution241 {
    val numbers = mutableListOf<Int>()
    val operators = mutableListOf<Char>()
    val memo = mutableMapOf<Pair<Int, Int>, List<Int>>()

    fun diffWaysToCompute(expression: String): List<Int> {
        var number = 0
        for (c in expression) {
            if (c.isDigit()) {
                number *= 10
                number += c.digitToInt()
            } else {
                numbers.add(number)
                number = 0
                operators.add(c)
            }
        }
        numbers.add(number)

        return diffWaysToCompute(0, operators.size)
    }

    fun diffWaysToCompute(oFrom: Int, oTo: Int): List<Int> {
        return memo.getOrPut(Pair(oFrom, oTo)) {
            computeSublist(oFrom, oTo)
        }
    }

    fun computeSublist(oFrom: Int, oTo: Int): List<Int> {
        if (oFrom == oTo) {
            return listOf(numbers[oFrom])
        } else if (oTo - oFrom == 1) {
            return listOf(calc(numbers[oFrom], numbers[oTo], operators[oFrom]))
        }

        val results = mutableListOf<Int>()
        for (i in oFrom..<oTo) {
            val op = operators[i]
            val before = diffWaysToCompute(oFrom, i)
            val after = diffWaysToCompute(i + 1, oTo)
            before.forEach { b -> after.forEach { a -> results.add(calc(b, a, op)) } }
        }
        return results
    }

    fun calc(num1: Int, num2: Int, operator: Char): Int {
        return when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            else -> Int.MAX_VALUE // never happens
        }
    }
}