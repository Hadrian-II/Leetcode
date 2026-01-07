package leetcode

fun main() {
    println(countTriples(5))
    println(countTriples(10))
}

fun countTriples(n: Int): Int {
    val squares = (1..n).map { it * it }
    var triples = 0
    for (h in (2..squares.lastIndex).reversed()) {
        for (k1 in 0..<squares.size - 2) {
            for (k2 in (k1+1)..<squares.size - 1) {
                val sum = squares[k1] + squares[k2]
                if (sum == squares[h]) {
                    triples += 2
                } else if (sum > squares[h]) {
                    break
                }
            }
        }
    }
    return triples
}