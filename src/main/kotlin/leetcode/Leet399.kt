package leetcode

import helpers.printDoubleArray
import helpers.readListOfListsStr
import kotlin.collections.map

fun main() {
    printDoubleArray(Solution399().calcEquation(
        readListOfListsStr("[[\"a\",\"b\"],[\"b\",\"c\"]]"),
        doubleArrayOf(2.0,3.0),
        readListOfListsStr("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]")))
    printDoubleArray(Solution399().calcEquation(
        readListOfListsStr("[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]"),
        doubleArrayOf(1.5,2.5,5.0),
        readListOfListsStr("[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]")))
    printDoubleArray(Solution399().calcEquation(
        readListOfListsStr("[[\"a\",\"b\"]]"),
        doubleArrayOf(0.5),
        readListOfListsStr("[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]")))
    printDoubleArray(Solution399().calcEquation(
        readListOfListsStr("[[\"a\",\"e\"],[\"b\",\"e\"]]"),
        doubleArrayOf(4.0,3.0),
        readListOfListsStr("[[\"a\",\"b\"],[\"e\",\"e\"],[\"x\",\"x\"]]"))) // 4 /3, 1, -1
    printDoubleArray(Solution399().calcEquation(
        readListOfListsStr("[[\"x1\",\"x2\"],[\"x2\",\"x3\"],[\"x3\",\"x4\"],[\"x4\",\"x5\"]]"),
        doubleArrayOf(3.0,4.0,5.0,6.0),
        readListOfListsStr("[[\"x1\",\"x5\"],[\"x5\",\"x2\"],[\"x2\",\"x4\"],[\"x2\",\"x2\"],[\"x2\",\"x9\"],[\"x9\",\"x9\"]]")))
}

class Solution399 {
    val input = HashMap<String, MutableList<Pair<String, Double>>>()

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        equations.forEachIndexed { i, e ->
            input.getOrPut(e[0]) { ArrayList() }.add(Pair(e[1], values[i]))
            input.getOrPut(e[1]) { ArrayList() }.add(Pair(e[0], 1 / values[i]))
        }
        return queries.map { calculateValue(Pair(it[0], it[1])) }.toDoubleArray()
    }

    fun calculateValue(search: Pair<String, String>): Double {
        if (search.first !in input || search.second !in input) {
            return -1.0
        }
        return calculateValue(search.first, search.second, 1.0, emptySet())
    }

    fun calculateValue(current: String, destination: String, value: Double, visited: Set<String>): Double {
        if (current !in input) {
            return -1.0
        }
        val v = visited + current
        for (d in input[current]!!) {
            if (d.first == destination) {
                return value * d.second
            } else if (d.first !in visited) {
                val res = calculateValue(d.first, destination, value * d.second, v)
                if (res != -1.0) {
                    return res
                }
            }
        }
        return -1.0
    }
}