package leetcode

import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(minimumDeletions("aababbab"))
    println(minimumDeletions("bbaaaaabb"))
    println(minimumDeletions("aba"))
    println(minimumDeletions("aaaaaabbbbabaaaabbabaaabbabbbaaabababaaaaaaabbaaabaaababaaabababa"))
    println(minimumDeletions("babbbbbbbababaababbbbbabaaabaabaabbbbbabbbaababababaaaabbbbaababbaabbbbbbaabbabababbbbbbaaaaaaaababababaababaaabaabbabbaaa"))
}

fun minimumDeletions(s: String): Int {
    val groups = ArrayList<Pair<Char, Int>>()
    var current: Char? = null
    var count = 0

    for (c in s) {
        count++
        if (c != current) {
            if (current != null) {
                groups.add(Pair(current, count))
            }
            current = c
            count = 0
        }
    }
    groups.add(Pair(current!!, count + 1))


    val aDeleted = IntArray(groups.size)
    var sumDeleted = 0
    for (i in groups.indices.reversed()) {
        aDeleted[i] = sumDeleted
        if (groups[i].first == 'a') {
            sumDeleted += groups[i].second
        }
    }

    sumDeleted = 0
    var minDeleted = Int.MAX_VALUE
    for (i in groups.indices) {
        minDeleted = min(minDeleted, sumDeleted + aDeleted[i])
        if (groups[i].first == 'b') {
            sumDeleted += groups[i].second
        }
    }


    return minDeleted
}