package leetcode

fun main() {
    println(processStr("a#b%*"))
    println(processStr("z*#"))
    println(processStr("*%"))
}

fun processStr(s: String): String {
    val result = StringBuilder()

    for (c in s) {
        when (c) {
            '*' -> if (result.isNotEmpty()) result.deleteCharAt(result.lastIndex)
            '#' -> result.append(result)
            '%' -> result.reverse()
            else -> result.append(c)
        }
    }

    return result.toString()
}