package leetcode

fun main() {
    println(findDifferentBinaryString(arrayOf("01", "10")))
    println(findDifferentBinaryString(arrayOf("00", "01")))
    println(findDifferentBinaryString(arrayOf("111", "011", "001")))
}

fun findDifferentBinaryString(nums: Array<String>): String {
    val res = StringBuilder()
    for (i in nums.indices) {
        res.append(if (nums[i][i] == '1') '0' else '1')
    }
    return res.toString()
}