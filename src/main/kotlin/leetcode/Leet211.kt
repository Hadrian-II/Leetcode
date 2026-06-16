package leetcode

fun main() {
    val w1 = WordDictionary()
    w1.addWord("bad")
    w1.addWord("dad")
    w1.addWord("mad")
    println(w1.search("pad"))
    println(w1.search("bad"))
    println(w1.search(".ad"))
    println(w1.search("b.."))
}

class WordDictionary() {
    val subTries = Array<WordDictionary?>(26) { null }
    var endsHere = false

    fun addWord(word: String) {
        addWord(word, 0)
    }

    fun addWord(word: String, ptr: Int) {
        if (ptr == word.length) {
            endsHere = true
        } else {
            val key = word[ptr] - 'a'
            if (subTries[key] == null) {
                subTries[key] = WordDictionary()
            }
            subTries[key]!!.addWord(word, ptr + 1)
        }
    }

    fun search(word: String): Boolean {
        return search(word, 0)
    }

    fun search(word: String, ptr: Int): Boolean {
        return if (ptr == word.length) {
            endsHere
        } else if (word[ptr] == '.') {
            subTries.any { it != null && it.search(word, ptr + 1) }
        } else {
            subTries[word[ptr] - 'a']?.search(word, ptr + 1) ?: false
        }
    }
}