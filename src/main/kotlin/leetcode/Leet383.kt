package leetcode

fun main() {
    println(canConstruct("a", "b"))
    println(canConstruct("aa", "ab"))
    println(canConstruct("aa", "aab"))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val letters = IntArray(26)
    for (letter in magazine.toCharArray()) {
        letters[letter - 'a']++
    }

    for (letter in ransomNote.toCharArray()) {
        if (--letters[letter - 'a'] < 0) {
            return false
        }
    }
    return true
}