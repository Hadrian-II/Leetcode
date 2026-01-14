package leetcode

import kotlin.math.max

fun main() {
    println(minFlips(2,6,5))
    println(minFlips(4,2,7))
    println(minFlips(1,2,3))
}

fun minFlips(a: Int, b: Int, c: Int): Int {
    val max = a.or(b).or(c)
    var bit = 1
    var flips = 0
    /*
    a b c flips
    0 0 0 0
    1 0 0 1
    0 1 0 1
    1 1 0 2
    0 0 1 1
    1 0 1 0
    0 1 1 0
    1 1 1 0
     */

    while (bit <= max) {
        if (c.and(bit) == bit) {
            if (a.or(b).and(bit) != bit) {
                flips++
            }
        } else {
            if (a.and(bit) == bit) {
                flips++
            }
            if (b.and(bit) == bit) {
                flips++
            }
        }
        bit = bit.shl(1)
    }
    return flips
}