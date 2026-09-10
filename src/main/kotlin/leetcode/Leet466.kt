package leetcode

fun main() {
    println(getMaxRepetitions("acb", 4, "ab", 2))
    println(getMaxRepetitions("acb", 1, "acb", 1))
    println(getMaxRepetitions("aaa", 3, "aa", 1))
    println(getMaxRepetitions("nlhqgllunmelayl", 10000, "lnl", 10))
}

fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
    var s2Index = 0
    var foundS2 = 0
    for (i in 0 until n1) {
        for (c in s1) {
            if (c == s2[s2Index]) {
                s2Index++
                if (s2Index == s2.length) {
                    s2Index = 0
                    foundS2++
                }
            }
        }
    }
    return foundS2 / n2
}