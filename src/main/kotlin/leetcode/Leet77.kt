package leetcode

fun main() {
    combine(4,2).forEach { println(it) }
    combine(1,1).forEach { println(it) }
}

fun combine(n: Int, k: Int): List<List<Int>> {
    return combinations((1..n).toList(), k)
}

fun combinations(numbers: List<Int>, pick: Int): List<MutableList<Int>> {
    return if (pick == 1) {
        numbers.map { mutableListOf(it) }
    } else {
        numbers.flatMap { nr -> combinations(numbers.filter { it > nr}, pick - 1).onEach { it.add(nr) } }
    }
}