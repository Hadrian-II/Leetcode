package leetcode

import kotlin.math.max

fun main() {
    Solution68().fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16).forEach { println("\"$it\"")}
    Solution68().fullJustify(arrayOf("What","must","be","acknowledgment","shall","be"), 16).forEach { println("\"$it\"")}
    Solution68().fullJustify(arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"), 20).forEach { println("\"$it\"")}
    Solution68().fullJustify(arrayOf("Listen","to","many,","speak","to","a","few."), 6).forEach { println("\"$it\"")}
    Solution68().fullJustify(arrayOf("a","b","c","d","e"), 3).forEach { println("\"$it\"")}
}

class Solution68 {
    lateinit var words: Array<String>
    var maxWidth = 0

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        this.words = words
        this.maxWidth = maxWidth

        var start = 0
        var currentLength = words[0].length
        val result = mutableListOf<String>()

        for (i in 1..words.lastIndex) {
            val length = words[i].length
            if (currentLength + length < maxWidth) {
                currentLength += length + 1
            } else {
                result.add(createLine(start, i - 1))
                start = i
                currentLength = length
            }
        }
        val lastLine = words.slice(start..words.lastIndex).joinToString(" ")
        result.add(lastLine + " ".repeat(maxWidth - lastLine.length))

        return result
    }

    fun createLine(start: Int, end: Int): String {
        val result = CharArray(maxWidth) { ' ' }
        var textSize = 0
        for (i in start..end) {
            textSize += words[i].length
        }
        val spaces = maxWidth - textSize

        val size = end - start
        val minSpaces = spaces / max(size, 1)
        var overSpaces = spaces % max(size, 1)

        var i = 0
        for (ix in start..end) {
            val word = words[ix]
            for (c in word) {
                result[i] = c
                i++
            }

            i += minSpaces + if (overSpaces > 0) 1 else 0
            overSpaces--
        }

        return String(result)
    }
}