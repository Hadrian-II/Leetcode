package leetcode

fun main() {
    println(isPerfectSquare(16))
    println(isPerfectSquare(14))
    println(isPerfectSquare(2147483647))
}

fun isPerfectSquare(num: Int): Boolean {
    val number = num.toLong()
    var max = num.toLong()
    var min = 0L
    while (max >= min) {
        val mid = max - ((max - min) / 2)
        val check = mid * mid
        if (check == number) {
            return true
        } else if (check > number) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }
    return false
}