package leetcode

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,1)))
    println(containsDuplicate(intArrayOf(1,2,3,4)))
    println(containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (num in nums) {
        if (num in set) {
            return true
        }
        set.add(num)
    }
    return false
}