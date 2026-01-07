package leetcode

fun main() {
    println(closeStrings("abc", "bca"))
    println(closeStrings("a", "aa"))
    println(closeStrings("cabbba", "abbccc")) //
    println(closeStrings("uau", "ssx"))       // false
}

fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) {
        return false
    }
    return isMutatable(word1, word2)
}

fun isMutatable(word1: String, word2: String): Boolean {
    if (word1.toSet() != word2.toSet()) {
        return false
    }
    val metrics1 = charMetrics(word1)
    val metrics2 = charMetrics(word2)
    if (metrics1.size != metrics2.size) {
        return false
    }
    for (i in metrics1.indices) {
        if (metrics1[i] != metrics2[i]) {
            return false
        }
    }
    return true
}

fun charMetrics(word: String): IntArray {
    return word.groupingBy { it }.eachCount().values.sorted().toIntArray()
}