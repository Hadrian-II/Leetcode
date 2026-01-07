package leetcode

fun main() {
    println(reverseWords("the sky is blue"))
    println(reverseWords("  hello world  "))
    println(reverseWords("a good   example"))
}

fun reverseWords(s: String): String {
    var words = s.split(" ")
    words = words.filter { it.isNotEmpty() }
    return words.reversed().joinToString(" ")
}