package leetcode

fun main() {
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("f11", "b23"))
    println(isIsomorphic("paper", "title"))
    println(isIsomorphic("badc", "baba"))
}

fun isIsomorphic(s: String, t: String): Boolean {
    val map = IntArray(256) {-1}
    for (i in s.indices) {
        val c = s[i].code
        if (map[c] == -1) {
            map[c] = t[i].code
        } else if (t[i].code != map[c]) {
            return false
        }
    }
    val keys = map.filter { it != -1 }
    return keys.size == keys.toSet().size
}