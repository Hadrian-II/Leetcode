package leetcode

fun main() {
    println(Solution139().wordBreak("leetcode", listOf("leet","code")))
    println(Solution139().wordBreak("applepenapple", listOf("apple","pen")))
    println(Solution139().wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
}

class Solution139 {
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

        fun allMatchLengths(searchIndex: Int, startIndex: Int, list: MutableList<Int>) {
            if (endsHere) {
                list.add(searchIndex - startIndex)
            }

            if (searchIndex < search.length) {
                subTries[search[searchIndex] - 'a']?.allMatchLengths(searchIndex + 1, startIndex, list)
            }
        }

        companion object {
            lateinit var search: String
        }
    }

    val trie = Trie()
    val memo = mutableMapOf<Int, Boolean>()
    var end: Int = 0
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        end = s.length
        trie.setSearch(s)
        for (word in wordDict) {
            trie.addWord(word, 0)
        }

        return canBuild(0)
    }

    fun canBuild(index: Int): Boolean {
        return memo.getOrPut(index) {
            if (index >= end) {
                index == end
            } else {
                val matches = mutableListOf<Int>()
                trie.allMatchLengths(index, index, matches)
                matches.any { canBuild(index + it )}
            }
        }
    }
}