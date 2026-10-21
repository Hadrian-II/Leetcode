package leetcode

fun main() {
    println(Solution500().findWords(arrayOf("Hello","Alaska","Dad","Peace")).joinToString(", "))
    println(Solution500().findWords(arrayOf("omk")).joinToString(", "))
    println(Solution500().findWords(arrayOf("adsdf","sfd")).joinToString(", "))
    println(Solution500().findWords(arrayOf("abdfs","cccd","a","qwwewm")).joinToString(", "))
}

class Solution500 {
    fun findWords(words: Array<String>): Array<String> {
        val result = mutableListOf<String>()

        words@ for (word in words) {
            val row = lookup[word.first().code]
            for (i in 1 until word.length) {
                if (lookup[word[i].code] != row) {
                    continue@words
                }
            }
            result.add(word)
        }

        return result.toTypedArray()
    }

    companion object {
        val lookup = IntArray(128)

        init {
            for (c in "qwertyuiopQWERTYUIOP") {
                lookup[c.code] = 1
            }
            for (c in "asdfghjklASDFGHJKL") {
                lookup[c.code] = 2
            }
            for (c in "zxcvbnmZXCVBNM") {
                lookup[c.code] = 3
            }
        }
    }
}