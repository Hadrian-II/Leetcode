package leetcode

fun main() {
    println(isPowerOfTwo(1))
    println(isPowerOfTwo(16))
    println(isPowerOfTwo(3))
}

fun isPowerOfTwo(n: Int): Boolean {
    if (n < 1) {
        return false
    }

    var number = n
    while (true) {
        if (number == 1) {
            return true
        }
        if (number and 1 == 1) {
            return false
        }
        number = number.shr(1)
    }
}