package leetcode

fun main() {
    val t = Trie()
    t.insert("apple")
    println(t.search("apple"))
    println(t.search("app"))
    println(t.startsWith("app"))
    t.insert("app")
    println(t.search("app"))
}

class Trie() {
    val aCode = 'a'.code
    val map = Array<Trie?>('z'.code - aCode + 1) { null }
    var thisWord = false

    fun index(char: Char): Int {
        return char.code - aCode
    }

    fun insert(word: String) {
        if (word.isEmpty()) {
            thisWord = true
            return
        }
        val code = index(word[0])
        if (map[code] == null) {
            map[code] = Trie()
        }
        map[code]!!.insert(word.substring(1))
    }

    fun search(word: String): Boolean {
        return if (word.isEmpty()) {
            thisWord
        } else {
            map[index(word[0])]?.search(word.substring(1)) ?: false
        }
    }

    fun startsWith(prefix: String): Boolean {
        return map[index(prefix[0])]?.let { if (prefix.length == 1) true else it.startsWith(prefix.substring(1)) } ?: false
    }
}