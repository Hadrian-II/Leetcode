package leetcode

fun main() {
    println(findComplement(5))
    println(findComplement(1))
    println(findComplement(Int.MAX_VALUE))
}

fun findComplement(num: Int): Int {
    var complement = 0
    var bin = 1

    while (bin <= num && bin > 0) {
        if (num.and(bin) == 0) {
            complement += bin
        }
        bin = bin.shl(1)
    }

    return complement
}