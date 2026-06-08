package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(Solution3635().earliestFinishTime(
        intArrayOf(2,8),
        intArrayOf(4,1),
        intArrayOf(6),
        intArrayOf(3)))
    println(Solution3635().earliestFinishTime(
        intArrayOf(5),
        intArrayOf(3),
        intArrayOf(1),
        intArrayOf(10)))
}

class Solution3635 {
    fun earliestFinishTime(landStartTime: IntArray, landDuration: IntArray, waterStartTime: IntArray, waterDuration: IntArray): Int {
        val minLandEnd = landStartTime.indices.minOf { landStartTime[it] + landDuration[it] }
        var minWaterAfterLand = Int.MAX_VALUE
        var minWaterEnd = Int.MAX_VALUE
        for (i in waterStartTime.indices) {
            val start = waterStartTime[i]
            val duration = waterDuration[i]
            minWaterAfterLand = min(minWaterAfterLand, max(minLandEnd, start) + duration)
            minWaterEnd = min(minWaterEnd, start + duration)
        }
        var minLandAfterWater = Int.MAX_VALUE
        for (i in landStartTime.indices) {
            minLandAfterWater = min(minLandAfterWater, max(minWaterEnd, landStartTime[i]) + landDuration[i])
        }

        return min(minWaterAfterLand, minLandAfterWater)
    }
}