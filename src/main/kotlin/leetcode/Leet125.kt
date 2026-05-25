package leetcode

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))

}

fun isPalindrome(s: String): Boolean {
    val alphaNumeric = s.lowercase().filter { it.isLetter() || it.isDigit() }

    if (alphaNumeric.isEmpty()) {
        return true
    }

    for (i in 0..(alphaNumeric.length / 2)) {
        if (alphaNumeric[i] != alphaNumeric[alphaNumeric.lastIndex - i]) {
            return false
        }
    }

    return true
}