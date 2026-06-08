package leetcode

import kotlin.math.abs
import kotlin.math.max

fun main() {
//    println(maximumGap(intArrayOf(3,6,9,1)))
//    println(maximumGap(intArrayOf(10)))
//    println(maximumGap(intArrayOf(1,3,100)))
//    println(maximumGap(intArrayOf(2, 99999999)))
    println(maximumGap(intArrayOf(1000000000,99999999,9999999,999999,99999,9999,999,99,9)))
}

fun maximumGap(nums: IntArray): Int {
    if (nums.size < 2) {
        return 0
    }

    var currentBuckets = Array(10) { mutableListOf<Int>() }

    for (num in nums) {
        currentBuckets[num % 10].add(num)
    }

    var potence = 10
    while (potence <= 1000000000) {
        val nextPotence = potence * 10
        val newBuckets = Array(10) { mutableListOf<Int>() }
        for (bucket in currentBuckets) {
            for (num in bucket) {
                newBuckets[(num % nextPotence) / potence].add(num)
            }
        }

        currentBuckets = newBuckets
        potence = nextPotence
    }

    var lastNum: Int? = null
    var maxDiff = 0
    for (bucket in currentBuckets) {
        for (num in bucket) {
            if (lastNum != null) {
                maxDiff = max(maxDiff, abs(num - lastNum))
            }

            lastNum = num
        }
    }

    return maxDiff
}