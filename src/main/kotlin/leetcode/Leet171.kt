package leetcode

fun main() {
    println(titleToNumber("A"))
    println(titleToNumber("AB"))
    println(titleToNumber("ZY"))
}

fun titleToNumber(columnTitle: String): Int {
    var result = 0
    for (c in columnTitle) {
        result *= 26
        val curr = c - 'A' + 1
        result += curr
    }
    return result
}