package leetcode

import kotlin.math.min

fun main() {
    println(minOperations("0100"))
    println(minOperations("10"))
    println(minOperations("1111"))
}

fun minOperations(s: String): Int {
    var changesFirst0 = 0
    var changesFirst1 = 0
    var current = '0'
    for (c in s) {
        if (c == current) {
            changesFirst1++
        } else {
            changesFirst0++
        }
        current = if (current == '0') '1' else '0'
    }

    return min(changesFirst0, changesFirst1)
}