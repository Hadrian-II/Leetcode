package leetcode

fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
    println(lengthOfLastWord("a"))
}

fun lengthOfLastWord(s: String): Int {
    var inWord = false
    var i = s.lastIndex
    var length = 0
    while (i >= 0) {
        if (s[i] == ' ') {
            if (inWord) {
                return length
            }
        } else {
            inWord = true
            length++
        }
        i--
    }
    return length
}