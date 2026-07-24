package leetcode

fun main() {
    println(isPowerOfFour(16))
    println(isPowerOfFour(5))
    println(isPowerOfFour(1))
}

fun isPowerOfFour(n: Int): Boolean {
    if (n < 1) {
        return false
    }
    var nr = n
    while (nr % 4 == 0) {
        nr /= 4
    }
    return nr == 1
}