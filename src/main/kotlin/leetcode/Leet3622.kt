package leetcode

fun main() {
    println(checkDivisibility(99))
    println(checkDivisibility(23))
}

fun checkDivisibility(n: Int): Boolean {
    val digits = mutableListOf<Int>()
    var nr = n
    while (nr > 0) {
        digits.add(nr % 10)
        nr /= 10
    }
    var sum = 0
    var product = 1
    for (digit in digits) {
        sum += digit
        product *= digit
    }

    return n % (sum + product) == 0
}