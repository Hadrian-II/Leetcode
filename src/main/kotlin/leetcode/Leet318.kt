package leetcode

import kotlin.math.max

fun main() {
    println(maxProduct(arrayOf("abcw","baz","foo","bar","xtfn","abcdef")))
    println(maxProduct(arrayOf("a","ab","abc","d","cd","bcd","abcd")))
    println(maxProduct(arrayOf("a","aa","aaa","aaaa")))
}

fun maxProduct(words: Array<String>): Int {
    val hashes = mutableMapOf<Int, Int>()
    for (word in words) {
        var hash = 0
        for (c in word) {
            hash = hash or 1.shl(c - 'a')
        }
        val old = hashes[hash]
        if (old == null || old < word.length) {
            hashes[hash] = word.length
        }
    }

    var max = 0
    val keys = hashes.keys.toList()
    for (i in 0..<keys.lastIndex) {
        val hi = keys[i]
        for (j in i + 1..keys.lastIndex) {
            val hj = keys[j]
            if (hi.and(hj) == 0) {
                max = max(max, hashes[hi]!! * hashes[hj]!!)
            }
        }
    }
    return max
}