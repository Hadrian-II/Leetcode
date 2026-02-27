package leetcode

fun main() {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }
    val result = CharArray(s.length)
    var i = 0
    val loopsize = (numRows * 2) - 2

    var j = 0
    while (j <= s.lastIndex) {
        result[i++] = s[j]
        j += loopsize
    }

    if (numRows > 2) {
        var k = 1
        while (k < numRows -1) {
            val antik = loopsize - k - k
            j = k
            while (j <= s.lastIndex) {
                result[i++] = s[j]
                if (j + antik <= s.lastIndex) {
                    result[i++] = s[j + antik]
                }
                j += loopsize
            }
            k++
        }
    }

    j = numRows - 1
    while (j <= s.lastIndex) {
        result[i++] = s[j]
        j += loopsize
    }

    return String(result)
}