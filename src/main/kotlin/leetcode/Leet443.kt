package leetcode

fun main() {
    println(compress(charArrayOf('a','a','b','b','c','c','c')))
    println(compress(charArrayOf('a')))
    println(compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
    println(compress(charArrayOf('a','a','a','b','b','a','a')))
}

fun compress(chars: CharArray): Int {
    var current: Char? = null
    var count = 1
    var ptr = 0
    for (char in chars + charArrayOf(1.toChar())) {
        if (current == null) {
            current = char
        } else {
            if (current == char) {
                count += 1
            } else {
                chars[ptr] = current
                current = char
                ptr += 1
                if (count > 1) {
                    count.toString().forEach {
                        chars[ptr] = it
                        ptr += 1
                    }
                    count = 1
                }
            }
        }
    }
    println(chars)
    return ptr
}