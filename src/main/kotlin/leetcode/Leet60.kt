package leetcode

import kotlin.math.max

fun main() {
    println(Solution60().getPermutation(3, 3))  // 213
    println(Solution60().getPermutation(4, 9))  // 2314
    println(Solution60().getPermutation(3, 1))  // 123
    println(Solution60().getPermutation(2, 2))  // 21
    println(Solution60().getPermutation(3, 2))  // 132
    println(Solution60().getPermutation(4, 6))  // 1432
}

class Solution60 {
    lateinit var  faculties: IntArray

    fun getPermutation(n: Int, k: Int): String {
        faculties = IntArray(n) { 1 }
        for (i in 2..n) {
            faculties[i - 1] = faculties[i - 2] * i
        }

        return getPerm((1..n).toList(), k - 1).toString()
    }

    fun getPerm(glyphs: List<Int>, k: Int): StringBuilder {
        if (k == 0) {
            val builder = StringBuilder()
            for (glyph in glyphs) {
                builder.append(glyph)
            }
            return builder
        }

        val fac = faculties[glyphs.size - 2]
        val current = glyphs[k / fac]
        val builder = getPerm(glyphs.filter { it != current }, k % fac)
        builder.insert(0, current)
        return builder
    }
}