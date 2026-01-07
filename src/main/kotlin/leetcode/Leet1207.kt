package leetcode

fun main() {
    println(uniqueOccurrences(intArrayOf(1,2,2,1,1,3)))
    println(uniqueOccurrences(intArrayOf(1,2)))
    println(uniqueOccurrences(intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)))
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val counts = arr.toTypedArray().groupingBy { it }.eachCount().values
    return counts.size == counts.distinct().size
}