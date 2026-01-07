package leetcode

import java.io.File
import kotlin.math.floor
import kotlin.time.measureTime

fun main() {
//    println(Solution3583().specialTriplets(intArrayOf(6,3,6)))                                       // 1
//    println(Solution3583().specialTriplets(intArrayOf(0,1,0,0)))                                     // 1
//    println(Solution3583().specialTriplets(intArrayOf(8,4,2,8,4)))                                   // 2
//    println(Solution3583().specialTriplets(intArrayOf(36,18,36,33,10,20)))                           // 1
//    println(Solution3583).specialTriplets(intArrayOf(85782,31437,81722,15755,17507,69579,24594,23197,40861,90372,99629,92362,17602,38968,29063,94366,30397,8997,80275,85638,48266,10580,29139,99000,28491,61478,31175,63424,10652,25264,61951,57083,81722,66993,41877,28744,17213,42819,66219,28999,3837,42283,7001,56193,40229,31455,53922,10385,97933,4100,57488,49138,69598,11228,85165,80096,22547,6954,62090,85522,28744,85638,23379,77892,64693,36236,39182,34535,24217,39525,71692,62420,80286,86592,35318,18381,62731,77154,15933,25579,6190,9179,50206,42740,83285,97616,76281,12398,57488,43725,35942,3440,20816,24638,65316,22254,291,76791,32426,95975,99668,30739,9128,60591,45646,61478,49280,50414,22882,89175,54055,82531,47897)))                           // 4
//    println(measureTime { println(Solution3583().specialTriplets(IntArray(100000))) })    // 665533373
//    println(measureTime { println(Solution3583().specialTriplets(File("src/main/kotlin/leetcode/input3583_1111")
//        .readLines().flatMap { it.split(",").map { it.toInt() } }.toIntArray())) })    // 350
//    println(measureTime { println(Solution3583().specialTriplets(File("src/main/kotlin/leetcode/input3583_1100")
//        .readLines().flatMap { it.split(",").map { it.toInt() } }.toIntArray())) })    // 6455
    println(measureTime { println(Solution3583().specialTriplets(File("src/main/kotlin/leetcode/input3583_1119")
        .readLines().flatMap { it.split(",").map { it.toInt() } }.toIntArray())) })    // 333179169
}
class Solution3583 {
    val DIVISOR = 1000000007

    fun specialTriplets(nums: IntArray): Int {
        val lookup = nums.mapIndexed { i, n -> Pair(n, i) }
            .groupBy({ it.first }, { it.second })
        var result = 0
        for (low in lookup.keys.filter { it * 2 in lookup }) {
            if (low == 0) {
                val size = lookup[low]!!.size
                if (size > 3) {
                    result += (size.toLong() * (size - 1) * (size - 2) / 6 % DIVISOR).toInt()
                } else if (size == 3) {
                    result += 1
                }
            } else {
                val high = low * 2
                val highs = lookup[high]!!
                if (highs.size < 2) {
                    continue
                }
                for (lowIndex in lookup[low]!!) {
                    if (lowIndex < highs[0] || lowIndex > highs[highs.lastIndex]) {
                        continue
                    } else if (highs.size == 2) {
                        result++
                        continue
                    } else if (highs.size == 3) {
                        result += 2
                        continue
                    }
                    var left = 0
                    var right = highs.lastIndex
                    while (left <= right) {
                        val mid = left + floor((right - left) / 2.0).toInt()
                        if (highs[mid] > lowIndex) {
                            right = mid - 1
                        } else if (mid < highs.size - 1 && highs[mid + 1] < lowIndex) {
                            left = mid + 1
                        } else {
                            val matches = (mid + 1) * (highs.size - (mid + 1))
                            result += matches
                            result %= DIVISOR
                            break
                        }
                    }
                }
            }
            result %= DIVISOR
        }
        return result
    }
}