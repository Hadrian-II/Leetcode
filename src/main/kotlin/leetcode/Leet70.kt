package leetcode

fun main() {
    println(climbStairs(2))
    println(climbStairs(3))
}

fun climbStairs(n: Int): Int {
    if (n == 1) {
        return 1
    }
    var next = 1
    var overnext = 1
    for (i in 0..n - 2) {
        val nbr = next
        next = nbr + overnext
        if (i != n - 2) {
            overnext = nbr
        }
    }
    return next
}