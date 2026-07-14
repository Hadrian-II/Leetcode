package leetcode

fun main() {
    val t = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    println(t.sumRange(0, 2))
    println(t.sumRange(2, 5))
    println(t.sumRange(0, 5))
}

class NumArray303(nums: IntArray) {

    private val pre: IntArray = IntArray(nums.size)

    init {
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            pre[i] = sum
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return if (left == 0) pre[right] else  pre[right] - pre[left - 1]
    }
}
