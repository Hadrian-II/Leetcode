package leetcode

fun main() {
    println(Solution3121().numberOfSpecialChars("aaAbcBC"))
    println(Solution3121().numberOfSpecialChars("abc"))
    println(Solution3121().numberOfSpecialChars("AbBCab"))
}

class Solution3121 {
    fun numberOfSpecialChars(word: String): Int {
        val seenLower = BooleanArray(26)
        val seenHigher = BooleanArray(26)
        val bust = BooleanArray(26)

        for (char in word) {
            if (char.isLowerCase()) {
                val ix = char - 'a'
                if (seenHigher[ix]) {
                    bust[ix] = true
                } else {
                    seenLower[ix] = true
                }

            } else {
                val ix = char - 'A'
                if (seenLower[ix]) {
                    seenHigher[ix] = true
                } else {
                    bust[ix] = true
                }
            }
        }

        return seenHigher.indices.count { seenHigher[it] && !bust[it] }
    }
}