package leetcode

import helpers.printIntArray
import kotlin.math.abs
import kotlin.random.Random

fun main() {
    val rand = Solution497(arrayOf(intArrayOf(-2, -2, 1, 1), intArrayOf(2, 2, 4, 6)))
    printIntArray(rand.pick())
    printIntArray(rand.pick())
    printIntArray(rand.pick())
}

class Solution497(rects: Array<IntArray>) {
    val rMap = mutableMapOf<Int, IntArray>()
    val keys = ArrayList<Int>(rects.size)
    var totKey = 0

    init {
        for (rect in rects) {
            totKey += abs(rect[2] - rect[0] + 1) * abs(rect[3] - rect[1] + 1)
            rMap[totKey] = rect
            keys.add(totKey)
        }
    }

    fun pick(): IntArray {
        val rand = Random.nextInt(totKey) + 1
        var rkey = keys.binarySearch(rand)
        if (rkey < 0) {
            rkey = abs(rkey + 1)
        }
        val rect = rMap[keys[rkey]]!!
        val x = abs(rect[2] - rect[0]) + 1
        val y = abs(rect[3] - rect[1]) + 1
        return intArrayOf(rect[0] + Random.nextInt(x), rect[1] + Random.nextInt(y))
    }
}