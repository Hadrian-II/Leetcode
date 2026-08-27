package leetcode

fun main() {
    println(validUtf8(intArrayOf(197,130,1)))
    println(validUtf8(intArrayOf(235,140,4)))
}

fun validUtf8(data: IntArray): Boolean {
    var i = 0
    while (i < data.size) {
        val byte = data[i]
        if (byte < 128) {
            i++
        } else if (byte.and(224) == 192 && i + 1 < data.size) {
            if (data[i + 1].and(192) != 128) {
                return false
            }
            i += 2
        } else if (byte.and(240) == 224 && i + 2 < data.size) {
            if (data[i + 1].and(192) != 128 ||
                data[i + 2].and(192) != 128) {
                return false
            }
            i += 3
        } else if (byte.and(248) == 240 && i + 3 < data.size) {
            if (data[i + 1].and(192) != 128 ||
                data[i + 2].and(192) != 128 ||
                data[i + 3].and(192) != 128) {
                return false
            }
            i += 4
        } else {
            return false
        }
    }
    return true
}