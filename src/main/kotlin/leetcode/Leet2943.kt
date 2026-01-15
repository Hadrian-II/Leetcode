package leetcode

import kotlin.math.max
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(maximizeSquareHoleArea(2,1, intArrayOf(2,3), intArrayOf(2)))     // 4
    println(maximizeSquareHoleArea(1,1, intArrayOf(2), intArrayOf(2)))       // 4
    println(maximizeSquareHoleArea(2,3, intArrayOf(2,3), intArrayOf(2,4)))   // 4
    println(maximizeSquareHoleArea(3,2, intArrayOf(3,2,4), intArrayOf(3,2))) // 9
    println(measureTime { println(maximizeSquareHoleArea(1000000000,1000000000, intArrayOf(1000000001), intArrayOf(1000000001)))})
}

fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
    val maxPossible = min(getMax(hBars.sorted()), getMax(vBars.sorted()))
    return maxPossible * maxPossible
}

fun getMax(bars: List<Int>): Int {
    if (bars.isEmpty()) {
        return 1
    } else if (bars.size == 1) {
        return 2
    }
    var current = 2
    var lastBar = -1
    var max = 0
    for (bar in bars) {
        if (lastBar == -1) {
            current = bar - 1
        } else {
            if (bar > lastBar + 1) {
                max = max(max, lastBar - current + 1)
                current = bar - 1
            }
        }
        lastBar = bar
    }
    return max(max, lastBar - current + 1)
}