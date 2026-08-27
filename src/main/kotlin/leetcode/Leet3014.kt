package leetcode

fun main() {
    println(minimumPushes("abcde"))
    println(minimumPushes("xycdefghij"))
}

fun minimumPushes(word: String): Int {
    val frequencies = IntArray(26)
    for (char in word) {
        frequencies[char - 'a']++
    }

    var pushes = 1
    var current = 0
    var result = 0
    for (amount in frequencies.sortedDescending()) {
        result += amount * pushes
        current++
        if (current == 8) {
            current = 0
            pushes++
        }
    }
    return result
}