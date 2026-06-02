package leetcode

fun main() {
    println(Solution140().wordBreak("catsanddog", listOf("cat","cats","and","sand","dog")))
    println(Solution140().wordBreak("pineapplepenapple", listOf("apple","pen","applepen","pine","pineapple")))
    println(Solution140().wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
}

class Solution140 {
    class Trie {
        val subTries = Array<Trie?>(26) { null }
        var endsHere = false

        fun setSearch(search: String) {
            Companion.search = search
        }

        fun addWord(word: String, index: Int) {
            if (word.length == index) {
                endsHere = true
            } else {
                val key = word[index] - 'a'
                val subTrie = if (subTries[key] == null) {
                    val t = Trie()
                    subTries[key] = t
                    t
                } else {
                    subTries[key]!!
                }
                subTrie.addWord(word, index + 1)
            }
        }

        fun allMatchLengths(searchIndex: Int, list: MutableList<StringBuilder>) {
            if (searchIndex < search.length) {
                subTries[search[searchIndex] - 'a']?.allMatchLengths(searchIndex + 1, list)
                list.forEach { it.insert(0, search[searchIndex]) }
            }

            if (endsHere) {
                list.add(StringBuilder())
            }
        }

        companion object {
            lateinit var search: String
        }
    }

    val trie = Trie()
    val memo = mutableMapOf<Int, List<String>>()
    var end: Int = 0
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        end = s.length
        trie.setSearch(s)
        for (word in wordDict) {
            trie.addWord(word, 0)
        }

        return getAllSentences(0)
    }

    fun getAllSentences(index: Int): List<String> {
        return memo.getOrPut(index) {
            val results = mutableListOf<StringBuilder>()
            trie.allMatchLengths(index, results)

            results.flatMap {
                if (it.length + index > end) {
                    emptyList()
                } else if (it.length + index == end) {
                    listOf(it.toString())
                } else {
                    getAllSentences(index + it.length).map { sub -> "$it $sub" }
                }
            }
        }
    }
}