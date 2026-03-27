package leetcode

fun main() {
    println(jump(intArrayOf(2,3,1,1,4)))
    println(jump(intArrayOf(2,3,0,1,4)))
    println(jump(intArrayOf(0)))
}

fun jump(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }
    var jumps = 0
    var current = nums.lastIndex
    while (current > 0) {
        var i = 0
        while (true) {
            if (nums[i] + i >= current) {
                current = i
                break
            }
            i++
        }
        jumps++
    }
    return jumps
}