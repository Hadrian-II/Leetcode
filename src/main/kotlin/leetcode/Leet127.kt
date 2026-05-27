package leetcode

fun main() {
    println(Solution127().ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
    println(Solution127().ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log")))
}

class Solution127 {
    class WordNode(val word: String) {
        var distance = Int.MAX_VALUE
        val links = mutableListOf<WordNode>()
    }

    val wordMap = HashMap<String, WordNode>()

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        wordMap[beginWord] = WordNode(beginWord)
        for (word in wordList) {
            wordMap[word] = WordNode(word)
        }
        if (endWord !in wordMap) {
            return 0
        }
        wordMap[beginWord]!!.distance = 0

        createGraph()

        calculateDistances(wordMap[beginWord]!!)

        if (wordMap[endWord]!!.distance == Int.MAX_VALUE) {
            return 0
        }

        return wordMap[endWord]!!.distance
    }

    private fun createGraph() {
        for (i in wordMap.keys.first().indices) {
            val map = HashMap<String, MutableList<String>>()

            for (word in wordMap.keys) {
                val key = word.filterIndexed { ix, _ -> ix != i }

                if (key in map) {
                    map[key]!!.add(word)
                } else {
                    map[key] = mutableListOf(word)
                }
            }

            for (connections in map.values.filter { it.size > 1 }) {
                for (i in connections.indices) {
                    for (j in i + 1..connections.lastIndex) {
                        val first = wordMap[connections[i]]!!
                        val second = wordMap[connections[j]]!!
                        first.links.add(second)
                        second.links.add(first)
                    }
                }
            }
        }
    }

    private fun calculateDistances(node: WordNode) {
        val next = node.distance + 1
        for (target in node.links) {
            if (target.distance > next) {
                target.distance = next
                calculateDistances(target)
            }
        }
    }

    private fun createLadders(node: WordNode): List<List<String>> {
        if (node.distance == 0) {
            return listOf(listOf(node.word))
        }

        return node.links.filter { it.distance == node.distance - 1 }
            .flatMap { createLadders(it).map { it + listOf(node.word) }}
    }
}