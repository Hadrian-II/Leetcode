package leetcode

fun main() {
    println(convertToTitle(1))
    println(convertToTitle(28))
    println(convertToTitle(701))
    println(convertToTitle(52))
}

fun convertToTitle(columnNumber: Int): String {
    var current = columnNumber
    val result = StringBuilder()

    while (current > 0) {
        current--
        val letter = current % 26
        result.append('A' + letter)
        current /= 26
    }

    return result.reversed().toString()
}