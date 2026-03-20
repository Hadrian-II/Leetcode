package leetcode

fun main() {
    println(removeElement(intArrayOf(3,2,2,3), 3))
    println(removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2))
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var iptr = 0
    var correct = 0
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[iptr++] = nums[i]
            correct++
        }
    }
    return correct
}