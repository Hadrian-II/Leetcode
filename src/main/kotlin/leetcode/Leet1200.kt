package leetcode

import kotlin.math.min

fun main() {
    minimumAbsDifference(intArrayOf(4,2,1,3)).forEach { println(it) }
    minimumAbsDifference(intArrayOf(1,3,6,10,15)).forEach { println(it) }
    minimumAbsDifference(intArrayOf(3,8,-10,23,19,-4,-14,27)).forEach { println(it) }
}

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    arr.sort()
    var i = arr.lastIndex
    var mindiff = Int.MAX_VALUE
    while(i >= 1) {
        mindiff = min(mindiff, arr[i] - arr[i - 1])
        i--
    }
    val result = mutableListOf<List<Int>>()
    i = 1
    while (i <= arr.lastIndex) {
        if (arr[i] - arr[i-1] == mindiff) {
            result.add(listOf(arr[i - 1], arr[i]))
        }
        i++
    }
    return result
}