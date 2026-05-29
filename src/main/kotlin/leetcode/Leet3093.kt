package leetcode

import helpers.printIntArray
import java.io.File
import java.util.Stack
import kotlin.collections.minOf
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    printIntArray(Solution3093().stringIndices(arrayOf("abcd","bcd","xbcd"), arrayOf("cd","bcd","xyz")))
    printIntArray(Solution3093().stringIndices(arrayOf("abcdefgh","poiuygh","ghghgh"), arrayOf("gh","acbfgh","acbfegh")))
    printIntArray(Solution3093().stringIndices(arrayOf("abcde","abcde"), arrayOf("abcde","bcde","cde","de","e")))
    println(
        measureTime {
            printIntArray(
                Solution3093().stringIndices(
                    File("src/main/kotlin/leetcode/input3093_813_0").readText().split(",")
                        .map { it.substring(1, it.length - 1) }.toTypedArray(),
                    File("src/main/kotlin/leetcode/input3093_813_1").readText().split(",")
                        .map { it.substring(1, it.length - 1) }.toTypedArray()
                )
            )
        }
    ) // 202,215,4606,103,1328,330,6546,739,137...
}

class Solution3093 {
    class Trie3093() {
        val subTries = Array<Trie3093?>(26) { null }
        var endsIx = Int.MAX_VALUE
        var bestIndex = Int.MAX_VALUE
        var bestDepth = Int.MAX_VALUE

        fun addWord(word: String, wi: Int, index: Int, depth: Int) {
            if (wi < 0) {
                endsIx = min(endsIx, index)
                bestIndex = endsIx
                bestDepth = depth
                return
            }

            val key = word[wi] - 'a'
            var child: Trie3093
            if (subTries[key] == null) {
                child = Trie3093()
                subTries[key] = child
            } else {
                child = subTries[key]!!
            }

            child.addWord(word, wi - 1, index, depth + 1)
            if (child.bestDepth < bestDepth ||
                (child.bestDepth == bestDepth && child.bestIndex < bestIndex)) {
                bestDepth = child.bestDepth
                bestIndex = child.bestIndex
            }
        }

        fun getBestMatchIndex(word: String, wi: Int): Int {
            if (wi < 0) {
                return bestIndex
            }

            val key = word[wi] - 'a'

            return if (subTries[key] == null) {
                bestIndex
            } else {
                subTries[key]!!.getBestMatchIndex(word, wi - 1)
            }
        }
    }
    val memo = HashMap<String, Int>()
    val trie = Trie3093()

    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        wordsContainer.forEachIndexed { index, word -> trie.addWord(word, word.lastIndex, index, 0) }

        return wordsQuery.map { getBestMatchIndex(it) }.toIntArray()
    }

    private fun getBestMatchIndex(word: String): Int {
        return memo.getOrPut(word) {
            trie.getBestMatchIndex(word, word.lastIndex)
        }
    }
}