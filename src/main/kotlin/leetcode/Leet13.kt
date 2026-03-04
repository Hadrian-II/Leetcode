package leetcode

fun main() {
    println(romanToInt("III"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
}

fun romanToInt(s: String): Int {
    var result = 0
    var i = 0
    while (i < s.length) {
        val next = if (i < s.length - 1) s[i + 1] else '$'
        when(s[i]) {
            'M' -> result += 1000
            'D' -> result += 500
            'C' -> when(next) {
                'M', 'D' -> result -= 100
                else -> result += 100
            }
            'L' -> result += 50
            'X' -> when(next) {
                'L', 'C' -> result -= 10
                else -> result += 10
            }
            'V' -> result += 5
            'I' -> when(next) {
                'V', 'X' -> result--
                else -> result++
            }
        }

        i++
    }
    return result
}