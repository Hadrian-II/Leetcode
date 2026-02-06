package leetcode

fun main() {
    println(licenseKeyFormatting("5F3Z-2e-9-w", 4))
    println(licenseKeyFormatting("2-5g-3-J", 2))
    println(licenseKeyFormatting("--a-a-a-a--", 2))
}

fun licenseKeyFormatting(s: String, k: Int): String {
    val output = StringBuilder()

    var added = 0
    for (current in s.reversed()) {
        if (current != '-') {
            if (added == k) {
                output.append('-')
                added = 0
            }
            output.append(if (current >= 'a') current - 32 else current)
            added += 1
        }
    }

    return output.reversed().toString()
}