package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(characterReplacement("ABAB", 2))
    println(characterReplacement("AABABBA", 1))
    println(characterReplacement("AAAA", 2))
    println(characterReplacement("AAAA", 0))
}

fun characterReplacement(s: String, k: Int): Int {
    val charIntervals = Array(26) { mutableListOf<Int>() }

    var last = s.first()
    var first = 0
    for (i in 0..s.lastIndex) {
        val c = s[i]
        if (c != last) {
            val ci = charIntervals[last - 'A']
            ci.add(first)
            ci.add(i-1)
            last = c
            first = i
        }
    }
    val ci = charIntervals[last - 'A']
    ci.add(first)
    ci.add(s.lastIndex)

    var max = 0

    for (intervals in charIntervals) {
        if (intervals.isEmpty()) continue

        var left = 0
        var totalCharCount = 0

        for (right in 0 until intervals.size step 2) {
            val rStart = intervals[right]
            val rEnd = intervals[right + 1]

            totalCharCount += (rEnd - rStart + 1)

            var currentSpan = rEnd - intervals[left] + 1
            var gaps = currentSpan - totalCharCount

            while (gaps > k && left < right) {
                val lStart = intervals[left]
                val lEnd = intervals[left + 1]
                totalCharCount -= (lEnd - lStart + 1)
                left += 2

                currentSpan = rEnd - intervals[left] + 1
                gaps = currentSpan - totalCharCount
            }

            max = max(max, currentSpan + k - gaps)
        }
    }

    return min(max, s.length)
}