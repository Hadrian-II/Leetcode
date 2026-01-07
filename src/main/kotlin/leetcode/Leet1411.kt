package leetcode

fun main() {
    println(Solution1411().numOfWays(1))
    println(Solution1411().numOfWays(5000))
}

class Solution1411 {
    val DIVISOR = 1000000007
    val memo = HashMap<Int, Map<Int, Long>>()

    fun numOfWays(n: Int): Int {
        var stateMap = initialState()
        for (i in 1..<n) {
            stateMap = stateMap.map { (key, value) -> getNext(key).mapValues { it.value * value } }.fold(mutableMapOf()) { acc, map ->
                map.forEach { (k, v) ->
                    acc[k] = (acc[k] ?: 0) + v
                    if (acc[k]!! > DIVISOR) {
                        acc[k] = acc[k]!! - DIVISOR
                    }
                }
                acc
            }
        }
        return (stateMap.values.sum() % DIVISOR).toInt()
    }

    private fun initialState(): Map<Int, Long> {
        val map = HashMap<Int, Long>()
        for (i in 0..2) {
            for (j in 0..2) {
                for (k in 0..2) {
                    if (i != j && j != k) {
                        map[i * 100 + j * 10 + k] = 1
                    }
                }
            }
        }
        return map
    }

    private fun getNext(key: Int): Map<Int, Long> {
        return memo.getOrPut(key) { calculateNext(key) }
    }

    private fun calculateNext(key: Int): Map<Int, Long> {
        val first = key / 100
        val second = (key / 10) % 10
        val third = key % 10
        val map = HashMap<Int, Long>()
        for (i in 0..2) {
            for (j in 0..2) {
                for (k in 0..2) {
                    if (i != j && j != k &&
                        i != first && j != second && k != third) {
                        map[i * 100 + j * 10 + k] = 1
                    }
                }
            }
        }
        return map
    }
}