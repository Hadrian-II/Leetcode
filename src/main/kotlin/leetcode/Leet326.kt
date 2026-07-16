package leetcode

fun main() {
    println(isPowerOfThree(27))
    println(isPowerOfThree(0))
    println(isPowerOfThree(-1))
    println(isPowerOfThree(80))
    println(isPowerOfThree(81))
}

fun isPowerOfThree(n: Int): Boolean {
    if (n < 1) {
        return false
    }
    var num = n
    while (num > 1) {
        if (num % 3 != 0)  {
            return false
        }
        num /= 3
    }
    return true
}