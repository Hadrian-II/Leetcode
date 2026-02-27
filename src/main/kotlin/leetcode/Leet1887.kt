package leetcode

fun main() {
    println(reductionOperations(intArrayOf(5,1,3)))
    println(reductionOperations(intArrayOf(1,1,1)))
    println(reductionOperations(intArrayOf(1,1,2,2,3)))
}

fun reductionOperations(nums: IntArray): Int {
    nums.sortDescending()

    var actions = 0
    var current = nums[0]
    var i = 1
    while (i <= nums.lastIndex) {
        if (nums[i] != current) {
            actions += i
            current = nums[i]
        }
        i++
    }
    return actions
}