package leetcode

fun main() {
    println(smallestPalindrome("z"))
    println(smallestPalindrome("babab"))
    println(smallestPalindrome("daccad"))
}

fun smallestPalindrome(s: String): String {
    val counts = IntArray(26)

    for (c in s) {
        counts[c - 'a']++
    }

    var mid = ""
    val result = StringBuilder()
    for (i in counts.indices) {
        val count = counts[i]
        if (count > 0) {
            val current = ('a' + i).toString()
            result.append(current.repeat(count / 2))
            if (count.and(1) == 1) {
                mid = current
            }
        }
    }

    return result.toString() + mid + result.reversed().toString()
}