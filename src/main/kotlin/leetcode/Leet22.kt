package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution22().generateParenthesis(3))
    println(Solution22().generateParenthesis(1))
    println(measureTime {
        Solution22().generateParenthesis(15)
    })
}

class Solution22 {
    val memo = HashMap<Pair<Int, Int>, List<String>>()
    fun generateParenthesis(n: Int): List<String> {
        return buildParathenses(n, 0)
    }

    fun buildParathenses(toOpen: Int, toClose: Int): List<String> {
        return memo.getOrPut(Pair(toOpen, toClose)) {
            if (toOpen > 0) {
                buildParathenses(toOpen - 1, toClose + 1).map { "($it" } + if (toClose > 0) buildParathenses(
                    toOpen,
                    toClose - 1
                ).map { ")$it" } else emptyList()
            } else {
                listOf(")".repeat(toClose))
            }
        }
    }
}