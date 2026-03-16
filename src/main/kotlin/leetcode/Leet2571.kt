package leetcode

fun main() {
    println(minOperations(39))
    println(minOperations(54))
    println(minOperations(27))
}

fun minOperations(n: Int): Int {
    var number = n
    var bit = 1
    var nextbit = 2
    var actions = 0
    while (number >= bit) {
        if (number.and(bit) == bit) {
            actions++
            if (number.and(nextbit) == nextbit) {
                number += bit
            } else {
                number -= bit
            }
        }
        bit = nextbit
        nextbit *= 2
    }
    return actions
}