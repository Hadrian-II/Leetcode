package leetcode

fun main() {
    println(hammingDistance(1, 4))
    println(hammingDistance(3, 1))
}

fun hammingDistance(x: Int, y: Int): Int {
    return x.xor(y).countOneBits()
}