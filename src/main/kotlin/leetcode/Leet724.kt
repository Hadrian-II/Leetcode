package leetcode

fun main() {
    println(pivotIndex(intArrayOf(1,7,3,6,5,6)))  // 3
    println(pivotIndex(intArrayOf(1,2,2,7,3,6,5,6,4)))  // 5
    println(pivotIndex(intArrayOf(1,2,3)))        // -1
    println(pivotIndex(intArrayOf(2,1,-1)))       // 0
    println(pivotIndex(intArrayOf(1,-1,2)))       // 2
}

fun pivotIndex(nums: IntArray): Int {
    val leftSum = IntArray(nums.size)
    var lCurrent = 0
    val rightSum = IntArray(nums.size)
    var rCurrent = 0
    for (i in nums.indices) {
        lCurrent += nums[i]
        leftSum[i] = lCurrent
        val rightI = nums.lastIndex - i
        rCurrent += nums[rightI]
        rightSum[rightI] = rCurrent
    }
    for (i in nums.indices) {
        if (leftSum[i] == rightSum[i]) {
            return i
        }
    }
    return -1
}