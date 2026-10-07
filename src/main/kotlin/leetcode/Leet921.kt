package leetcode

fun main() {
    println(minAddToMakeValid("(()"))
    println(minAddToMakeValid("((("))
}

fun minAddToMakeValid(s: String): Int {
    var toAdd = 0
    var open = 0
    for (c in s) {
        when(c) {
            '(' -> open++
            ')' -> {
                if (open > 0) {
                    open--
                } else {
                    toAdd++
                }
            }
        }
    }
    return toAdd + open
}