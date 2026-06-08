package leetcode

import kotlin.math.max

fun main() {
    println(compareVersion("1.2", "1.10"))
    println(compareVersion("1.01", "1.001"))
    println(compareVersion("1.0", "1.0.0.0"))
    println(compareVersion("1.0.1", "1"))
}

fun compareVersion(version1: String, version2: String): Int {
    var ptr1 = 0
    var ptr2 = 0

    while (ptr1 < version1.length || ptr2 < version2.length) {
        var v1 = 0

        while (ptr1 < version1.length) {
            if (version1[ptr1] == '.') {
                ptr1++
                break
            }
            v1 *= 10
            v1 += version1[ptr1] - '0'
            ptr1++
        }

        var v2 = 0

        while (ptr2 < version2.length) {
            if (version2[ptr2] == '.') {
                ptr2++
                break
            }
            v2 *= 10
            v2 += version2[ptr2] - '0'
            ptr2++
        }

        if (v1 > v2) {
            return 1
        } else if (v2 > v1) {
            return -1
        }
    }
    return 0
}