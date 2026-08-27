package leetcode

fun main() {
    println(findTheDifference("abcd", "abcde"))
    println(findTheDifference("", "y"))
}

fun findTheDifference(s: String, t: String): Char {
    val chars = IntArray(26)
    for (c in t) {
        chars[c - 'a']++
    }
    for (c in s) {
        chars[c - 'a']--
    }
    for (i in chars.indices) {
        if (chars[i] == 1) {
            return 'a' + i
        }
    }
    return ' '
}