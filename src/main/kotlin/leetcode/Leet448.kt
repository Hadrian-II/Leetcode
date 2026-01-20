package leetcode

fun main() {
    println(findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)))
    println(findDisappearedNumbers(intArrayOf(1,1)))
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val frequency = IntArray(nums.size + 1)
    for (num in nums) {
        frequency[num]++
    }
    val result = ArrayList<Int>()
    for (i in 1..frequency.lastIndex) {
        if (frequency[i] == 0) {
            result.add(i)
        }
    }
    return result
}