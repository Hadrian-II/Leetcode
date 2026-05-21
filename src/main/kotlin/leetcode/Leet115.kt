package leetcode

fun main() {
    println(Solution115().numDistinct("rabbbit", "rabbit"))
    println(Solution115().numDistinct("babgbag", "bag"))
}

class Solution115() {
    val memo = HashMap<Pair<String, String>, Int>()

    fun numDistinct(s: String, t: String): Int {
        return memo.getOrPut(Pair(s, t)) {
            if (t.isEmpty()) {
                1
            } else if (t.length > s.length) {
                0
            } else if (s.first() == t.first()) {
                numDistinct(s.substring(1), t.substring(1)) + numDistinct(s.substring(1), t)
            } else {
                numDistinct(s.substring(1), t)
            }
        }
    }
}