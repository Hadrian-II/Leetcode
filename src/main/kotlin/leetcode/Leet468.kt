package leetcode

fun main() {
    println(Solution468().validIPAddress("172.16.254.1"))
    println(Solution468().validIPAddress("256.256.256.256"))
    println(Solution468().validIPAddress("01.01.01.01"))
    println(Solution468().validIPAddress("12..33.4"))
    println(Solution468().validIPAddress("172.16.204.1"))
    println(Solution468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
    println(Solution468().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"))
}

class Solution468 {
    fun validIPAddress(queryIP: String): String {
        return if (queryIP.contains('.')) {
            parseV4(queryIP)
        } else if (queryIP.contains(':')) {
            parseV6(queryIP)
        } else {
            "Neither"
        }
    }

    private fun parseV6(queryIP: String): String {
        if (queryIP.first() == ':' || queryIP.last() == ':') {
            return "Neither"
        }
        var segmentCount = 0
        var digitCount = 0
        for (c in queryIP) {
            if (c == ':') {
                if (digitCount !in 1..4) {
                    return "Neither"
                }
                segmentCount++
                digitCount = 0
            } else {
                if (c  in '0'..'9' || c in 'a'..'f' || c in 'A'..'F') {
                    digitCount++
                } else {
                    return "Neither"
                }
            }
        }
        return if (digitCount in 1..4 && segmentCount == 7) "IPv6" else "Neither"
    }

    private fun parseV4(queryIP: String): String {
        if (queryIP.first() == '.' || queryIP.last() == '.') {
            return "Neither"
        }
        var segmentCount = 0
        var value = 0
        var digitCount = 0
        for (c in queryIP) {
            if (c == '.') {
                if (digitCount == 0) {
                    return "Neither"
                }
                value = 0
                segmentCount++
                digitCount = 0
            } else {
                val digit = c - '0'
                if (digit !in 0..9) {
                    return "Neither"
                }
                if (digitCount > 0 && value == 0) {
                    return "Neither"
                }
                value = value * 10 + digit
                if (value > 255) {
                    return "Neither"
                }
                digitCount++
            }
        }
        return if (digitCount in 1..3 && segmentCount == 3) "IPv4" else "Neither"
    }
}