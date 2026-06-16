package leetcode

fun main() {
    println(containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
    println(containsNearbyDuplicate(intArrayOf(1,0,1,1), 1))
    println(containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val matchMap = HashSet<Int>(k + 1)
    for (i in nums.indices) {
        val num = nums[i]
        if (!matchMap.add(num)) {
            return true
        }

        if (i >= k) {
            matchMap.remove(nums[i - k])
        }
    }
    return false
}