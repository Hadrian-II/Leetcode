package leetcode

fun main() {
    println(bitwiseComplement(5))
    println(bitwiseComplement(7))
    println(bitwiseComplement(10))
}

fun bitwiseComplement(n: Int): Int {
    if (n == 0) {
        return 1
    }
    var nr = 1
    var result = 0
    while (nr < n) {
        if (nr.and(n) != nr) {
            result += nr
        }
        nr *= 2
    }
    return result
}