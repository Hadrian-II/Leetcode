package leetcode

fun main() {
    println(isSubsequence("abc", "ahbgdc"))   // true
    println(isSubsequence("axc", "ahbgdc"))   // false
    println(isSubsequence("aaaaaa", "bbaaaa"))// false
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    if (t.isEmpty()) {
        return false
    }
    var tptr = 0
    for (schr in s) {
        if (tptr == t.length) {
            return false
        }
        while (t[tptr] != schr) {
            tptr += 1
            if (tptr == t.length) {
                return false
            }
        }
        tptr += 1
    }
    return true
}