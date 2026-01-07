package leetcode

fun main() {
    println(maxOperations(intArrayOf(1,2,3,4), 5))      // 2
    println(maxOperations(intArrayOf(3,1,3,4,3), 6))    // 1
    println(maxOperations(intArrayOf(3,1,5,1,1,1,1,1,2,2,3,2,2), 1)) // 0
}

fun maxOperations(nums: IntArray, k: Int): Int {
    val buffer = HashMap<Int, Int>()
    var ops = 0
    for (num in nums) {
        val other = k - num
        if (num < k) {
            if ((buffer[other] ?: 0) > 0) {
                ops++
                buffer[other] = (buffer[other] ?: 0) - 1
            } else {
                buffer[num] = (buffer[num] ?: 0) + 1
            }
        }
    }
    return ops
}