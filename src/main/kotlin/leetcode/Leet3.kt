package leetcode

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("aabaab!bb"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var max = 0
    val letters = HashSet<Char>()
    var ptr = 0
    for (i in s.indices) {
        val c = s[i]
        if (c in letters) {
            while (c != s[ptr]) {
                letters.remove(s[ptr])
                ptr++
            }
            letters.remove(s[ptr])
            ptr++
        }
        letters.add(c)
        max = max(max, letters.size)
    }
    return max
}