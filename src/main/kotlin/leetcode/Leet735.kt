package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(asteroidCollision(intArrayOf(5,10,-5)))
    printIntArray(asteroidCollision(intArrayOf(8,-8)))
    printIntArray(asteroidCollision(intArrayOf(10,2,-5)))
    printIntArray(asteroidCollision(intArrayOf(3,5,-6,2,-1,4)))
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val leftGoing = ArrayList<Int>()
    val rightGoing = ArrayDeque<Int>()
    for (asteroid in asteroids) {
        if (asteroid < 0) {
            if (crash(asteroid * -1, rightGoing)) {
                leftGoing.add(asteroid)
            }
        } else {
            rightGoing.addLast(asteroid)
        }
    }
    return (leftGoing + rightGoing).toIntArray()
}

fun crash(asteroid: Int, others: ArrayDeque<Int>): Boolean {
    while (others.isNotEmpty()) {
        val other = others.last()
        if (other <= asteroid) {
            others.removeLast()
        }
        if (asteroid <= other) {
            return false
        }
    }
    return true
}