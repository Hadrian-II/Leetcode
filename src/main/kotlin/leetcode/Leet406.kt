package leetcode

fun main() {
    println(toHex(26))
    println(toHex(-1))
}

fun toHex(num: Int): String {
    if (num == 0) {
        return "0"
    }
    val bits = BooleanArray(32)
    for (i in bits.indices) {
        val bit = 1.shl(i)
        bits[i] = num.and(bit) == bit
    }
    val result = StringBuilder()
    for (i in 0..7) {
        val digit = (if (bits[i * 4]) 1 else 0) + (if (bits[i * 4+ 1]) 2 else 0) + (if (bits[i * 4 + 2]) 4 else 0) + (if (bits[i * 4 + 3]) 8 else 0)
        if (digit > 9) {
            result.append('a' + digit - 10)
        } else {
            result.append(digit)
        }
    }
    return result.reversed().toString().trimStart('0')
}