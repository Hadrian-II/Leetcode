package leetcode

fun main() {
    println(decodeString("3[a]2[bc]"))
    println(decodeString("3[a2[c]]"))
    println(decodeString("2[abc]3[cd]ef"))
}

fun decodeString(s: String): String {
    var result = ""
    val strStack = ArrayDeque<String>()
    var count = 0
    val countStack = ArrayDeque<Int>()
    for (c in s) {
        if (c == '[') {
            strStack.add(result)
            result = ""
            countStack.add(count)
            count = 0
        } else if (c == ']') {
            result = strStack.removeLast() + result.repeat(countStack.removeLast())
        } else if (c.isDigit()) {
            count *= 10
            count += c.digitToInt()
        } else {
            result += c
        }
    }
    return result
}