package leetcode

import kotlin.math.max

fun main() {
    println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
    println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
    println(lengthLongestPath("a"))
}

fun lengthLongestPath(input: String): Int {
    var longest = 0
    var currentWord = 0
    val path = ArrayDeque<Int>()
    var tabCount = 0
    var inFile = false
    var pSum = 0
    for (c in input.toCharArray()) {
        when (c) {
            '\n' -> {
                if (inFile) {
                    if (pSum == 0) {
                        pSum = path.sum()
                    }
                    longest = max(longest, currentWord + pSum + path.size)
                } else {
                    path.add(currentWord)
                    if (pSum != 0) {
                        pSum = 0
                    }
                }
                currentWord = 0
                tabCount = 0
                inFile = false
            }
            '\t' -> {
                tabCount++
            }
            else -> {
                while (path.size > tabCount) {
                    path.removeLast()
                    if (pSum != 0) {
                        pSum = 0
                    }
                }
                if (c == '.') {
                    inFile = true
                }
                currentWord++
            }
        }
    }
    if (inFile) {
        longest = max(longest, currentWord + path.sum() + path.size)
    }
    return longest
}