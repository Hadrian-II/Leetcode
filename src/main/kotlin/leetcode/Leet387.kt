package leetcode

import kotlin.math.min

fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("aabb"))
}

fun firstUniqChar(s: String): Int {
    val ABSENT = -2
    val MULTIPLE = -1
    val chars = IntArray(26) { ABSENT }
    for (i in s.indices) {
        val c = s[i] - 'a'
        val cc = chars[c]
        if (cc == ABSENT) {
            chars[c] = i
        } else if (cc != MULTIPLE){
            chars[c] = MULTIPLE
        }
    }
    var min = Int.MAX_VALUE
    for (c in chars) {
        if (c >= 0) {
            min = min(c, min)
        }

    }
    return if (min == Int.MAX_VALUE) -1 else min
}