package leetcode

fun main() {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
    println(isAnagram("ggii", "eekk"))
    println(isAnagram("hqbqo", "lsnma"))
    println(isAnagram("dcccc", "bbbbe"))
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val frequency = IntArray(26)

    for (i in s.indices) {
        frequency[s[i] - 'a']++
        frequency[t[i] - 'a']--
    }

    return frequency.all { it == 0 }
}