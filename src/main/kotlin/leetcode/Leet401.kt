package leetcode

fun main() {
    println(readBinaryWatch(1))
    println(readBinaryWatch(9))
}

fun readBinaryWatch(turnedOn: Int): List<String> {
    val result = mutableListOf<String>()

    var h = 0
    while (h < 12) {
        val hBits = Integer.bitCount(h)

        if (hBits > turnedOn) {
            h++
            continue
        }

        var m = 0
        while (m < 60) {
            if (hBits + Integer.bitCount(m) == turnedOn) {
                if (m > 9) {
                    result.add("$h:$m")
                } else {
                    result.add("$h:0$m")
                }
            }
            m++
        }
        h++
    }

    return result
}