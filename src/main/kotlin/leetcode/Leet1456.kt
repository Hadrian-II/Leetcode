package leetcode

import kotlin.math.max

fun main() {
    println(maxVowels("abciiidef", 3))
    println(maxVowels("aeiou", 2))
    println(maxVowels("leetcode", 3))
}

fun maxVowels(s: String, k: Int): Int {
    val vowels = "aeiou"
    var current = 0
    var max = 0
    for (i in s.indices) {
        if (s[i] in vowels) {
            current++
        }
        if (i >= k && s[i - k] in vowels) {
            current--
        }
        if (current == k) {
            return current
        }
        max = max(max, current)
    }
    return max
}