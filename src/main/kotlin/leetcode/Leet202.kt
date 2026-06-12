package leetcode

fun main() {
    println(isHappy(19))
    println(isHappy(2))
}

fun isHappy(n: Int): Boolean {
    val visited = mutableSetOf(n)
    var current = n
    while (current != 1) {
        var new = 0
        while (current > 0) {
            val digit = current % 10
            new += digit * digit
            current /= 10
        }
        if (new in visited) {
            return false
        }
        visited.add(new)
        current = new
    }
    return true
}