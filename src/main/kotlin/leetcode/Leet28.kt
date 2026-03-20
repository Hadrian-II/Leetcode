package leetcode

fun main() {
    println(strStr("sadbutsad", "sad"))     // 0
    println(strStr("leetcode", "leeto"))    // -1
    println(strStr("mississippi", "issip")) // 4
    println(strStr("mississippi", "pi"))    // 9
    println(strStr("aaabb", "baba"))        // -1
    println(strStr("a", "a"))               // 0
    println(strStr("aaaa", "aaaa"))         // 0
}

fun strStr(haystack: String, needle: String): Int {
    val checkRange = 1..needle.lastIndex
    for (i in 0..haystack.length - needle.length) {
        if (haystack[i] == needle[0]) {
            var ok = true
            for (j in checkRange) {
                if (i + j > haystack.lastIndex || haystack[i + j] != needle[j]) {
                    ok = false
                    break
                }
            }
            if (ok) {
                return i
            }
        }
    }
    return -1
}