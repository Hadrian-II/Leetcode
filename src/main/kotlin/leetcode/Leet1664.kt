package leetcode

fun main() {
    println(waysToMakeFair(intArrayOf(2,1,6,4)))
    println(waysToMakeFair(intArrayOf(1,1,1)))
    println(waysToMakeFair(intArrayOf(1,2,3)))
    println(waysToMakeFair(intArrayOf(4,1,1,2,5,1,5,4)))
}

fun waysToMakeFair(nums: IntArray): Int {
    var oddSumFront = 0
    var evenSumFront = 0
    var even = true
    for (i in nums.indices) {
        if (even) {
            evenSumFront += nums[i]
        } else {
            oddSumFront += nums[i]
        }
        even = !even
    }

    var fairCount = 0

    var oddSumEnd = 0
    var evenSumEnd = 0
    even = nums.size % 2 == 1
    for (i in nums.indices.reversed()) {
        if (even) {
            evenSumFront -= nums[i]

        } else {
            oddSumFront -= nums[i]
        }
        if (evenSumFront + oddSumEnd == oddSumFront + evenSumEnd) {
            fairCount++
        }
        if (even) {
            evenSumEnd += nums[i]

        } else {
            oddSumEnd += nums[i]
        }
        even = !even
    }

    return fairCount
}