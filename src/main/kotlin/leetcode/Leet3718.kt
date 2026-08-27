package leetcode

fun main() {
    println(missingMultiple(intArrayOf(8,2,3,4,6), 2))
    println(missingMultiple(intArrayOf(1,4,7,10,15), 5))
}

fun missingMultiple(nums: IntArray, k: Int): Int {
    nums.sort()
    var expected = k
    for (num in nums) {
        if (num == expected) {
            expected += k
        } else if (num > expected) {
            return expected
        }
    }
    return expected
}