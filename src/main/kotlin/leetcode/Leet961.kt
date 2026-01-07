package leetcode

fun main() {
    println(repeatedNTimes(intArrayOf(1,2,3,3)))
    println(repeatedNTimes(intArrayOf(2,1,2,5,3,2)))
    println(repeatedNTimes(intArrayOf(5,1,5,2,5,3,5,4)))
}

fun repeatedNTimes(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (num in nums) {
        if (num !in map) {
            map[num] = 0
        }
        map[num] = map[num]!! + 1
    }
    return map.filter { it.value == nums.size / 2 }.map { it.key }.first()
}