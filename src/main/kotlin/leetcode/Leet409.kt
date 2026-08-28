package leetcode

fun main() {
    println(longestPalindrome("abccccdd"))
    println(longestPalindrome("a"))
    println(longestPalindrome("Za"))
}

fun longestPalindrome(s: String): Int {
    val map = IntArray(52)
    val off = 'A' - 26
    for (c in s) {
        if (c >= 'a') {
            map[c - 'a']++
        } else {
            map[c - off]++
        }
    }
    var result = 0
    var single = false

    for (num in map) {
        val bit = num.and(1)
        if (bit == 1 && !single) {
            single = true
        }
        result += (num - bit)
    }

    return result + (if (single) 1 else 0)
}