package leetcode

fun main() {
    println(hammingWeight(11))
    println(hammingWeight(128))
    println(hammingWeight(2147483645))
}

fun hammingWeight(n: Int): Int {
    var nr = n
    var bits = 0
    while (nr > 0) {
        if (nr.and(1) == 1) {
            bits++
        }
        nr = nr.shr(1)
    }
    return bits
}