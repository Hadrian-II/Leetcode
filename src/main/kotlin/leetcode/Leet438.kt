package leetcode

fun main() {
    println(findAnagrams("cbaebabacd", "abc"))
    println(findAnagrams("abab", "ab"))
}

fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length) {
        return emptyList()
    }

    val pFrequency = IntArray(26)
    for (c in p) {
        pFrequency[c - 'a']++
    }

    val result = mutableListOf<Int>()
    val sFrequency = IntArray(26)
    val pSize = p.length
    val pLi = pSize - 1
    for (i in s.indices) {
        if (i >= pSize) {
            sFrequency[s[i - pSize] - 'a']--
        }
        val c = s[i]
        sFrequency[c - 'a']++
        if (i >= pLi) {
            if (pFrequency.contentEquals(sFrequency)) {
                result.add(i - pLi)
            }
        }
    }
    return result
}