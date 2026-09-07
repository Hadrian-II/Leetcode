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
    for (char in chars) {
        if (current == null) {
            current = char
        } else {
            if (current == char) {
                count++
            } else {
                chars[ptr++] = current
                current = char
                if (count > 1) {
                    count.toString().forEach {
                        chars[ptr++] = it
                    }
                    count = 1
                }
            }
        }
    }
    chars[ptr++] = current!!
    if (count > 1) {
        count.toString().forEach {
            chars[ptr++] = it
        }
    }
    println(chars)
    return ptr
}