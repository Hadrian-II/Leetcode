package leetcode

fun reverseString(s: CharArray): Unit {
    for (i in 0..<s.size/2) {
        val buf = s[i]
        s[i] = s[s.lastIndex - i]
        s[s.lastIndex - i] = buf
    }
}