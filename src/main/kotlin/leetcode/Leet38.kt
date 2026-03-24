package leetcode

fun main() {
    println(countAndSay(4))
    println(countAndSay(1))
    println(countAndSay(30))
}

fun countAndSay(n: Int): String {
    var string = "1"
    var todo = n - 1
    while (todo > 0) {
        string = rle(string)
        todo--
    }
    return string
}

fun rle(s: String): String {
    var result = StringBuilder()
    var current: Char? = null
    var count = 0
    for(c in s) {
        if (current == null) {
            current = c
        }
        if (c != current) {
            result.append("${count}$current")
            count = 0
            current = c
        }
        count ++

    }
    result.append("${count}$current")
    return result.toString()
}