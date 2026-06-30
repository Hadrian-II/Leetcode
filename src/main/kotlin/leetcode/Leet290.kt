package leetcode
fun main() {
    println(wordPattern("abba", "dog cat cat dog"))
    println(wordPattern("abba", "dog cat cat fish"))
    println(wordPattern("aaaa", "dog cat cat dog"))
    println(wordPattern("jquery", "jquery"))
}

fun wordPattern(pattern: String, s: String): Boolean {
    val map = HashMap<String, Char>()
    val mappedChars = mutableSetOf<Char>()
    val words = s.split(' ')
    if (words.size != pattern.length) {
        return false
    }
    for (i in words.indices) {
        val word = words[i]
        val currentChar = pattern[i]
        val mapped = map[word]

        if (mapped != null) {
            if (currentChar != mapped) {
                return false
            }
        } else if (currentChar in mappedChars) {
            return false
        } else {
            map[word] = currentChar
            mappedChars.add(currentChar)
        }
    }

    return true
}