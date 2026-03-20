package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution30().findSubstring("barfoothefoobarman", arrayOf("foo","bar")))
    println(Solution30().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word")))
    println(Solution30().findSubstring("barfoofoobarthefoobarman", arrayOf("bar","foo","the")))
    println(Solution30().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good")))
    println(Solution30().findSubstring("cbbabcbac", arrayOf("ab","cb")))
    println(measureTime {
    println(Solution30().findSubstring("a".repeat(30000),
            Array(20000) { "a" }))
    })
    println(Solution30().findSubstring("aaaccccaab", arrayOf("cc","cc")))
}

class Solution30 {
    class ActiveMatch(
        val start: Int,
        var wordStart: Int,
        var currentWord: Int,
        var leftoverWords: List<Pair<Int, Int>>
    ) {
        override fun toString(): String {
            return "Start: $start, WordStart: $wordStart, Word: $currentWord, Leftover: ${leftoverWords.joinToString(",") { it.toString() }}"
        }
    }

    lateinit var distinctWords: MutableMap<String, Int>
    lateinit var distinctMap: List<String>

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val searchLength = words.sumOf { it.length }
        var activeMatches = mutableListOf<ActiveMatch>()
        distinctWords = words.groupingBy { it }.eachCount().toMutableMap()
        if (distinctWords.size == 1) {
            val newWord = distinctWords.keys.first().repeat(distinctWords.values.first())
            distinctWords.remove(distinctWords.keys.first())
            distinctWords[newWord] = 1
        }
        distinctMap = distinctWords.keys.toList()
        val startlist = distinctMap.mapIndexed { i, word -> Pair(word, i) }.groupBy { it.first.first() }
        val result = mutableListOf<Int>()

        for (i in s.indices) {
            val c = s[i]
            val newActive = mutableListOf<ActiveMatch>()
            for (active in activeMatches) {
                val activeIndex = i - active.wordStart
                if (activeIndex < distinctMap[active.currentWord].length && distinctMap[active.currentWord][activeIndex] == c) {
                    newActive.add(active)
                } else if (activeIndex == distinctMap[active.currentWord].length) {
                    if (active.leftoverWords.isEmpty()) {
                        result.add(active.start)
                    } else {
                        for (word in active.leftoverWords) {
                            if (distinctMap[word.first].startsWith(c)) {
                                newActive.add(
                                    ActiveMatch(
                                        active.start,
                                        i,
                                        word.first,
                                        active.leftoverWords.mapNotNull { updateValue(it, word) })
                                )
                            }
                        }
                    }
                }
            }
            if (i + searchLength <= s.length) {
                if (c in startlist) {
                    for (word in startlist[c]!!) {
                        newActive.add(
                            ActiveMatch(
                                i,
                                i,
                                word.second,
                                distinctWords.mapNotNull { newValue(it, word) })
                        )
                    }
                }
            } else if (newActive.isEmpty()) {
                break
            }
            activeMatches = newActive
        }

        for (active in activeMatches) {
            if (active.start == s.length - searchLength && active.leftoverWords.isEmpty() && words[active.currentWord].endsWith(s.last())) {
                result.add(active.start)
            }
        }

        return result
    }

    fun updateValue(value: Pair<Int, Int>, word: Pair<Int, Int>): Pair<Int, Int>? {
        var count = value.second
        if (value.first == word.first) {
            count--
        }
        return if (count > 0) {
            Pair(value.first, count)
        } else {
            null
        }
    }

    fun newValue(entry: Map.Entry<String, Int>, word: Pair<String, Int>): Pair<Int, Int>? {
        var count = entry.value
        if (entry.key == word.first) {
            count--
        }
        return if (count > 0) {
            Pair(distinctMap.indexOf(entry.key), count)
        } else {
            null
        }
    }
}