package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution40().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
    println(Solution40().combinationSum2(intArrayOf(2,5,2,1,2), 5))
    println(measureTime {
        println(Solution40().combinationSum2(IntArray(100) { 1 }, 33))
    })
}

class Solution40 {
    lateinit var candidates: List<Pair<Int, Int>>
    val memo = HashMap<Pair<Int, Int>, List<List<Int>>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates.sorted().groupingBy { it }.eachCount().toList()
        val blah = csum(0, target)
        return blah
    }

    fun csum(i: Int, target: Int): List<List<Int>> {
        return memo.getOrPut(Pair(i, target)) {
            val result = mutableListOf<List<Int>>()

            for (ix in i..candidates.lastIndex) {
                if (candidates[ix].first > target) {
                    break
                }
                if (candidates[ix].first * candidates[ix].second >= target) {
                    if (target % candidates[ix].first == 0) {
                        result.add(List(target / candidates[ix].first) { candidates[ix].first })
                    }
                }
                for(j in 1..candidates[ix].second) {
                    val current = candidates[ix].first * j
                    if (current < target) {
                        result.addAll(csum(ix + 1, target - current).map { List(j) { candidates[ix].first } + it })
                    } else {
                        break
                    }
                }
            }

            result
        }
    }
}