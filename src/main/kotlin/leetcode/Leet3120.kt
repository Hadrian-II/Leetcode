package leetcode

fun main() {
    println(numberOfSpecialChars("aaAbcBC"))
    println(numberOfSpecialChars("abc"))
    println(numberOfSpecialChars("abBCab"))
}

fun numberOfSpecialChars(word: String): Int {
    val lower = BooleanArray(26)
    val upper = BooleanArray(26)

    for (char in word) {
        if (char.isUpperCase()) {
            upper[char - 'A'] = true
        } else {
            lower[char - 'a'] = true
        }
    }

    return (0..25).count { lower[it] && upper[it] }
}