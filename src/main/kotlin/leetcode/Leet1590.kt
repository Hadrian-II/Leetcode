package leetcode

import java.io.File
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(minSubarray(intArrayOf(4,1), 4))     // 1
    println(minSubarray(intArrayOf(3,1,4,2), 6)) // 1
    println(minSubarray(intArrayOf(6,3,5,2), 9)) // 2
    println(minSubarray(intArrayOf(1,2,3), 3))   // 0
    println(minSubarray(intArrayOf(1,2,3), 7))   // -1
    println(minSubarray(intArrayOf(1000000000,1000000000,1000000000), 3)) // 0
    println(minSubarray(intArrayOf(3,6,8,1), 8)) // -1
    val data = File("src/main/kotlin/leetcode/inputprefix_2").readLines()[0].split(",").map { it.toInt() }.toIntArray()
    println(measureTime {
        println(minSubarray(data, 226574574)) // -1
    })
    println(minSubarray(intArrayOf(8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2), 148)) // 7
}

fun minSubarray(nums: IntArray, p: Int): Int {
    val prefixSum = IntArray(nums.size)
    var sum = 0
    for (i in nums.indices) {
        sum = (sum + nums[i]) % p
        prefixSum[i] = sum
    }
    val off = prefixSum.last()
    if (off == 0) {
        return 0
    }
    val map = HashMap<Int, Int>()
    map[0] = -1
    var minSize = Int.MAX_VALUE
    for (i in prefixSum.indices) {
        val c = (prefixSum[i] + p - off) % p
        map[c]?.let { minSize = min(i - it, minSize) }
        map[prefixSum[i]] = i
    }
    return if (minSize == nums.size) -1 else minSize
}