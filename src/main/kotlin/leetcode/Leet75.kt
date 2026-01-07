package leetcode

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations("2"))
}

fun letterCombinations(digits: String): List<String> {
    val digitMap = HashMap<Char, CharArray>()
    digitMap['2'] = charArrayOf('a', 'b', 'c')
    digitMap['3'] = charArrayOf('d', 'e', 'f')
    digitMap['4'] = charArrayOf('g', 'h', 'i')
    digitMap['5'] = charArrayOf('j', 'k', 'l')
    digitMap['6'] = charArrayOf('m', 'n', 'o')
    digitMap['7'] = charArrayOf('p', 'q', 'r', 's')
    digitMap['8'] = charArrayOf('t', 'u', 'v')
    digitMap['9'] = charArrayOf('w', 'x', 'y', 'z')
    var results = listOf(charArrayOf())
    for (digit in digits) {
        results = digitMap[digit]!!.flatMap { char -> results.map { str -> str + char } }
    }
    return results.map { it.joinToString("") }
}