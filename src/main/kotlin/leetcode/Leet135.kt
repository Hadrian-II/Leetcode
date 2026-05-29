package leetcode

import kotlin.math.max

fun main() {
    println(candy(intArrayOf(1,0,2)))
    println(candy(intArrayOf(1,2,2)))
}

fun candy(ratings: IntArray): Int {
    val ladder = IntArray(ratings.size)
    ladder[0] = 1
    var minCandies = 1
    var last = ratings.first()
    var i = 1
    while (i < ratings.size) {
        if (ratings[i] > last) {
            minCandies++
        } else {
            minCandies = 1
        }
        ladder[i] = minCandies

        last = ratings[i]
        i++
    }

    minCandies = 1
    last = ratings.last()
    i = ratings.lastIndex - 1
    var sum = ladder.last()
    while (i >= 0) {
        if (ratings[i] > last) {
            minCandies++
        } else {
            minCandies = 1
        }
        sum += max(ladder[i], minCandies)

        last = ratings[i]
        i--
    }

    return sum
}