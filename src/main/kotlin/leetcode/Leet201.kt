package leetcode

fun main() {
    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 0))
    println(rangeBitwiseAnd(1, 2147483647))
}

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var l = left
    var r = right
    var removed = 0
    while (l != r) {
        l = l.shr(1)
        r = r.shr(1)
        removed++
    }
    return l.shl(removed)
}