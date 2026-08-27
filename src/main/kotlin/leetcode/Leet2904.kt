package leetcode

fun main() {
    println(shortestBeautifulSubstring("100011001", 3))
    println(shortestBeautifulSubstring("1011", 2))
    println(shortestBeautifulSubstring("1011", 1))
    println(shortestBeautifulSubstring("000", 1))
    println(shortestBeautifulSubstring("111111110010001010", 11))
    println(shortestBeautifulSubstring("001", 1))
}

fun shortestBeautifulSubstring(s: String, k: Int): String {
    var start = s.indexOf('1')
    if (start == -1) {
        return ""
    } else if (k == 1) {
        return "1"
    }
    var end = start + 1
    var ones = 1
    var best = ""
    while (end < s.length) {
        while (ones < k && end < s.length) {
            if (s[end] == '1') {
                ones++
            }
            end++
        }
        if (ones < k) {
            return best
        }
        val check = s.substring(start, end)
        if (best == "" ||
            check.length < best.length ||
            (check.length == best.length && check < best)) {
            best = check
            if (best.length == k) {
                return best
            }
        }
        start++
        while (start < s.length && s[start] == '0') {
            start++
        }
        ones--
    }
    return best
}
