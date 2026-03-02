package leetcode

fun main() {
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    var buf = x
    var reversed = 0
    while (buf > 0) {
        reversed *= 10
        reversed += buf % 10
        buf /= 10
    }
    return reversed == x
}