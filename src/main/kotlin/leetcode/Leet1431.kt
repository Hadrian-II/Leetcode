package leetcode

fun main() {
    println(kidsWithCandies(intArrayOf(2,3,5,1,3), 3))
    println(kidsWithCandies(intArrayOf(4,2,1,1,2), 1))
    println(kidsWithCandies(intArrayOf(12,1,12), 10))
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val maxCandies = candies.max()
    return candies.map { it + extraCandies >= maxCandies }
}