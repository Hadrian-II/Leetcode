package leetcode

fun main() {
    println(Solution39().combinationSum(intArrayOf(2,3,6,7), 7))
    println(Solution39().combinationSum(intArrayOf(2,3,5), 8))
    println(Solution39().combinationSum(intArrayOf(2), 1))
}


class Solution39() {
    lateinit var candidates: List<Int>
    val memo = HashMap<Pair<Int, Int>, List<List<Int>>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates.filter { it <= target }.sorted()
        if (this.candidates.isEmpty()) {
            return emptyList()
        }
        return combinations(target, 1)
    }

    fun combinations(target: Int, min: Int): List<List<Int>> {
        return memo.getOrPut(Pair(target, min)) {
            if (target < candidates[0]) {
                emptyList()
            } else {
                val result = mutableListOf<List<Int>>()

                for (candidate in candidates) {
                    if (candidate < min) {
                        continue
                    } else if (candidate == target) {
                        result.add(listOf(candidate))
                    } else if (candidate > target) {
                        break
                    } else {
                        result.addAll(combinations(target - candidate, candidate).map { listOf(candidate) + it  })
                    }
                }

                result
            }
        }
    }
}