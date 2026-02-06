package leetcode

fun main() {
    println(maskPII("LeetCode@LeetCode.com"))
    println(maskPII("AB@qq.com"))
    println(maskPII("1(234)567-890"))
}

fun maskPII(s: String): String {
    return if (s.contains('@')) {
        maskEmail(s)
    } else {
        maskTel(s)
    }
}

fun maskEmail(s: String): String {
    val split = s.lowercase().split('@')
    return "${split[0][0]}*****${split[0][split[0].lastIndex]}@${split[1]}"
}

fun maskTel(s: String): String {
    val numbers = s.filter { it.isDigit() }
    val prefix = when (numbers.length) {
        13 -> "+***-"
        12 -> "+**-"
        11 -> "+*-"
        else -> ""
    }
    return "$prefix***-***-${numbers.substring(numbers.lastIndex - 3)}"
}