package leetcode

import kotlin.math.abs

fun main() {
    println(furthestDistanceFromOrigin("L_RL__R"))
    println(furthestDistanceFromOrigin("_R__LL_"))
    println(furthestDistanceFromOrigin("_______"))
}

fun furthestDistanceFromOrigin(moves: String): Int {
    var position = 0
    var free = 0
    for (move in moves) {
        when (move) {
            'L' -> position++
            'R' -> position--
            '_' -> free++
        }
    }
    return abs(position) + free
}