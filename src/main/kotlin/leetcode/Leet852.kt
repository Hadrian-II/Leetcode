package leetcode

fun main() {
    println(peakIndexInMountainArray(intArrayOf(0,1,0)))
    println(peakIndexInMountainArray(intArrayOf(0,2,1,0)))
    println(peakIndexInMountainArray(intArrayOf(0,10,5,2)))
}

fun peakIndexInMountainArray(arr: IntArray): Int {
    var first = 0
    var last = arr.lastIndex
    while (first + 1 < last) {
        val mid = (first + last) / 2
        if (arr[mid] > arr[mid + 1]) {
            last = mid
        } else {
            first = mid
        }
    }
    return last
}