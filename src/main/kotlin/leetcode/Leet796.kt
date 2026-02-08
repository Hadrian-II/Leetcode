package leetcode

fun main() {
    println(rotateString("abcde", "cdeab"))
    println(rotateString("abcde", "abced"))
}

fun rotateString(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }

    for (i in s.indices) {
        for (j in s.indices) {
            if (s[j] != goal[(i+j) % s.length]) {
                break
            }

            if (j == s.lastIndex) {
                return true
            }
        }
    }
    return false
}