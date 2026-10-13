package leetcode

fun main() {
    println(maxAlternatingSum(intArrayOf(1,2,3)))
    println(maxAlternatingSum(intArrayOf(-3,-1,-2,1,3,2)))
    println(maxAlternatingSum(intArrayOf(14,15,-10,-9,4)))
}

fun maxAlternatingSum(nums: IntArray): Long {
    val squares = IntArray(nums.size)
    for (i in nums.indices) {
        val num = nums[i]
        squares[i] = num * num
    }
    squares.sort()
    var lptr = 0
    var hptr = nums.lastIndex
    var add = true
    var sum = 0L
    while (lptr <= hptr) {
        if (add) {
            sum += squares[hptr--]
        } else {
            sum -= squares[lptr++]
        }
        add = !add
    }
    return sum
}