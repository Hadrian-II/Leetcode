package leetcode

fun main() {
    println(addDigits(38))
    println(addDigits(0))
}

fun addDigits(num: Int): Int {
    var result = num
    while (result > 9) {
        var calc = 0
        while (result > 0) {
            calc += result % 10
            result /= 10
        }
        result = calc
    }
    return result
}