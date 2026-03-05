package leetcode

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix(arrayOf("")))
    println(longestCommonPrefix(arrayOf("a", "")))
    println(longestCommonPrefix(arrayOf("a", "ac")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs[0] == "") {
        return ""
    }
    val result = strs[0]
    var i = 1
    var last = result.length
    while (i < strs.size && last > 0) {
        var j = 0
        while (j <= last && j < result.length) {
            if (j == strs[i].length || strs[i][j] != result[j]) {
                last = j
                break
            }
            j++
        }
        i++
    }
    return if (last > 0) result.take(last) else ""
}