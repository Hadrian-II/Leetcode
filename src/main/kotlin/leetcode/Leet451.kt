package leetcode

import java.util.TreeMap

fun main() {
    println(frequencySort("tree"))
    println(frequencySort("cccaaa"))
    println(frequencySort("Aabb"))
}

fun frequencySort(s: String): String {
    val frequencies = IntArray(128)
    for (c in s) {
        frequencies[c.code]++
    }
    val map = mutableListOf<Pair<String, Int>>()
    var i = '0'.code
    while (i <= 'z'.code) {
        val count = frequencies[i]
        if (count > 0) {
            map.add(Pair(i.toChar().toString(), count))
        }
        i++
    }

    map.sortByDescending { it.second }
    val result = StringBuilder()
    for (entry in map) {
        result.append(entry.first.repeat(entry.second))
    }
    return result.toString()
}