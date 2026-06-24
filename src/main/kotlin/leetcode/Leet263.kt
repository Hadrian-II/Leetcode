package leetcode

fun main() {
    println(isUgly(6))
    println(isUgly(1))
    println(isUgly(14))
}

fun isUgly(n: Int): Boolean {
    if (n < 1) {
        return false
    }
    var number = n
    while (number % 5 == 0) {
        number /= 5
    }
    while (number % 3 == 0) {
        number /= 3
    }
    while (number % 2 == 0) {
        number /= 2
    }
    return number == 1
}