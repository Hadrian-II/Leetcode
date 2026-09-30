package leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(findRadius(intArrayOf(1,2,3), intArrayOf(2)))
    println(findRadius(intArrayOf(1,2,3,4), intArrayOf(1,4)))
    println(findRadius(intArrayOf(1,5), intArrayOf(2)))
    println(findRadius(intArrayOf(1,5), intArrayOf(10)))
    println(findRadius(intArrayOf(282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923),
                       intArrayOf(823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612)))
}

fun findRadius(houses: IntArray, heaters: IntArray): Int {
    houses.sort()
    heaters.sort()
    var maxDistance = 0
    val hiterator = heaters.iterator()
    var lastHeater = hiterator.nextInt()
    var nextHeater = if (hiterator.hasNext()) hiterator.nextInt() else Int.MAX_VALUE
    for (house in houses) {
        while (house > nextHeater) {
            lastHeater = nextHeater
            nextHeater = if (hiterator.hasNext()) hiterator.nextInt() else Int.MAX_VALUE
        }
        maxDistance = max(maxDistance, min(abs(house - lastHeater), nextHeater - house))
    }
    return maxDistance
}