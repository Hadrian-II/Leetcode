package leetcode

fun main() {
    println(countCollisions("RLRSLL"))
    println(countCollisions("LLRR"))
}

fun countCollisions(directions: String): Int {
    val carnageZone = directions.trimStart('L').trimEnd('R')
    return carnageZone.split('S').joinToString("").length
}