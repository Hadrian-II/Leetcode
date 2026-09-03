package leetcode

fun main() {
    println(countSegments("Hello, my name is John"))
    println(countSegments("Hello"))
    println(countSegments("                "))
}

fun countSegments(s: String): Int {
    var segments = 0
    var inWord = false
    for (c in s) {
        if (c == ' ') {
            if (inWord) {
                inWord = false
            }
        } else if (!inWord) {
            segments++
            inWord = true
        }
    }
    return segments
}