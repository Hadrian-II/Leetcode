package leetcode

fun main() {
    println(totalHammingDistance(intArrayOf(4,14,2)))
    println(totalHammingDistance(intArrayOf(4,14,4)))
    println(totalHammingDistance(intArrayOf(6,1,8,6,8)))
}

fun totalHammingDistance(nums: IntArray): Int {
    var result = 0
    for (i in 0 until 31) {
        var count = 0
        for (num in nums) {
            count += num.shr(i).and(1)
        }
        result += count * (nums.size - count)
    }

    return result
}