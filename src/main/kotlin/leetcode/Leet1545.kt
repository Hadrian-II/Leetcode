package leetcode

fun main() {
    println(findKthBit(3,1))
    println(findKthBit(4,11))
}

fun findKthBit(n: Int, k: Int): Char {
    val res = BooleanArray(k)
    res[0] = false
    var ptr = 1
    while (ptr <= k - 1) {
        res[ptr++] = true
        var endcpy = ptr - 2
        while (endcpy >= 0 && ptr <= k - 1) {
            res[ptr++] = !res[endcpy--]
        }
    }
    return if (res[k - 1]) '1' else '0'
}