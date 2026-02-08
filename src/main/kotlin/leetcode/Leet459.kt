package leetcode

fun main() {
    println(repeatedSubstringPattern("abab"))
    println(repeatedSubstringPattern("aba"))
    println(repeatedSubstringPattern("abcabcabcabc"))
}

fun repeatedSubstringPattern(s: String): Boolean {
    var subLength = 1
    val half = s.length / 2
    while (subLength <= half) {
        if (s.length % subLength == 0) {
            if (s.take(subLength).repeat(s.length / subLength) == s) {
                return true
            }
        }
        subLength++
    }
    return false
}