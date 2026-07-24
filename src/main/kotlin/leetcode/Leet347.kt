package leetcode

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencyMap = mutableMapOf<Int, Int>()

    for (num in nums) {
        frequencyMap[num] = frequencyMap[num]?.let { it + 1 } ?: 1
    }

    return frequencyMap
               .entries
               .sortedByDescending { it.value }
               .subList(0, k)
               .map { it.key }
               .toIntArray()
}