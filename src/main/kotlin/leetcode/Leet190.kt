package leetcode

fun main() {
    println(reverseBits(43261596))
    println(reverseBits(2147483644))
}

fun reverseBits(n: Int): Int {
    var start = n
    var result = 0
    var i = 0
    while (i < 31) {
        result = result.shl(1)
        if (start % 2 == 1) {
            result++
        }
        start = start.shr(1)
        i++
    }
    return result * 2
}