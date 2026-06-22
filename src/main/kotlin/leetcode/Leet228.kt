package leetcode

fun main() {
    summaryRanges(intArrayOf(0,1,2,4,5,7)).forEach { println(it)}
    summaryRanges(intArrayOf(0,2,3,4,6,8,9)).forEach { println(it)}
}

fun summaryRanges(nums: IntArray): List<String> {
    if (nums.isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<String>()
    var start: Int? = null
    var end: Int? = null

    for (num in nums) {
        if (start == null) {
            start = num
        } else if (num == (end ?: start) + 1) {
            end = num
        } else {
            if (end == null) {
                result.add("$start")
            } else {
                result.add("$start->$end")
            }
            start = num
            end = null
        }
    }

    if (end == null) {
        result.add("$start")
    } else {
        result.add("$start->$end")
    }

    return result
}