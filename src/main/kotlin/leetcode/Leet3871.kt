package leetcode

fun main() {
    println(countCommas(1002L))
    println(countCommas(998L))
}

fun countCommas(n: Long): Long {
    var noComma = 999L
    var result = 0L

    while (noComma < n) {
        result += n - noComma
        noComma *= 1000
        noComma += 999
    }

    return result
}