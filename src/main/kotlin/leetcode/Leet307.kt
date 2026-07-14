package leetcode

fun main() {
    val t1 = NumArray(intArrayOf(1,3,5))
    println(t1.sumRange(0,2))
    t1.update(1,2)
    println(t1.sumRange(0, 2))
}

class NumArray(val nums: IntArray) {

    private val pre: IntArray = IntArray(nums.size)

    init {
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            pre[i] = sum
        }
    }

    fun update(index: Int, `val`: Int) {
        val diff = nums[index] - `val`
        for (i in index until nums.size) {
            pre[i] -= diff
        }
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        return if (left == 0) pre[right] else  pre[right] - pre[left - 1]
    }
}