package leetcode

fun main() {
    println(combinationSum3(3, 7))
    println(combinationSum3(3, 9))
    println(combinationSum3(4, 1))
    println(combinationSum3(2, 18))
}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    return combinationSum(1, k, n) ?: emptyList()
}

fun combinationSum(min: Int, k: Int, n: Int): List<List<Int>>? {
    val maxPossible = (9-(k-1)..9).sum()
    if (n > maxPossible) {
        return null
    }
    if (k == 1) {
        return if (n in min..9) {
            listOf(listOf(n))
        } else {
            null
        }
    }
    return (min..9).mapNotNull { if (n - min >= it + 1) combinationSum(it + 1, k - 1, n - it)?.map { result -> result + listOf(it) } else null }.flatten()
}