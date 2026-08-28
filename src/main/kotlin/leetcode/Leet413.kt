package leetcode

fun main() {
    println(numberOfArithmeticSlices(intArrayOf(1,2,3,4)))
    println(numberOfArithmeticSlices(intArrayOf(1)))
}

fun numberOfArithmeticSlices(nums: IntArray): Int {
    if (nums.size < 3) {
        return 0
    }
    var result = 0

    var length = 0
    var last = nums[1]
    var diff = last - nums[0]
    var i = 2
    while (i < nums.size) {
        val current = nums[i]
        val nDiff = current - last
        if (diff == nDiff) {
            length++
            result += length
        } else {
            length = 0
            diff = nDiff
        }
        last = current
        i++
    }
    return result
}