package leetcode

fun main() {
    println(isNumber("0")) // t
    println(isNumber("e"))
    println(isNumber("."))
    println(isNumber("0e"))
    println(isNumber("0x11"))
    println(isNumber("-1E+3")) // t
    println(isNumber("4e+"))
    println(isNumber(".-4"))
    println(isNumber("32.e-80123")) // t
}

fun isNumber(s: String): Boolean {
    var signFound = false
    var expFound = false
    var dotFound = false
    var inNumber = false
    for (c in s) {
        if ((c == '+' || c == '-') && !inNumber && !signFound && !dotFound) {
            signFound = true
        } else if ((c == 'e' || c == 'E') && inNumber && !expFound) {
            expFound = true
            signFound = false
            inNumber = false
            dotFound = false
        } else if (c == '.' && !dotFound && !expFound) {
            dotFound = true
        } else if (c.isDigit()) {
            inNumber = true
        } else {
            return false
        }
    }
    return inNumber
}