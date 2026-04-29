package leetcode

fun main() {
    subsets(intArrayOf(1,2,3)).forEach { println(it) }
    println("-------")
    subsets(intArrayOf(1,2)).forEach { println(it) }
}

fun subsets(nums: IntArray): List<List<Int>> {
    val result = listOf(listOf<Int>())
    return result + combinations(nums.toList())
}

fun combinations(numbers: List<Int>): MutableList<MutableList<Int>> {
    return if (numbers.size == 1) {
        mutableListOf(mutableListOf(numbers[0]))
    } else {
        numbers.flatMap { nr ->
            val without = combinations(numbers.filter { it < nr })
            without.onEach { it.add(nr) }
            without.add(mutableListOf(nr))
            without
        }.toMutableList()
    }
}