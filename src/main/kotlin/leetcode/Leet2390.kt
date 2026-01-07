package leetcode

fun main() {
    println(removeStars("leet**cod*e"))
    println(removeStars("erase*****"))
}

fun removeStars(s: String): String {
    val letterStack = ArrayDeque<Char>()
    for (letter in s) {
        if (letter == '*') {
            letterStack.removeLast()
        } else {
            letterStack.addLast(letter)
        }
    }
    return letterStack.joinToString("")
}