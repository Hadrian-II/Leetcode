package leetcode

fun main() {
    println(reverseVowels("IceCreAm")) // AceCreIm
    println(reverseVowels("leetcode")) // leotcede
}

fun reverseVowels(s: String): String {
    val sArr = s.toCharArray()
    val vowels = "aeiouAEIOU"
    var start = 0
    var end = sArr.size - 1
    var forward = true
    while (start < end) {
        if (forward) {
            if (sArr[start] in vowels) {
                forward = false
            } else {
                start += 1
            }
        } else {
            if (sArr[end] in vowels) {
                val buffer = sArr[end]
                sArr[end] = sArr[start]
                sArr[start] = buffer
                forward = true
                start += 1
            }
            end -= 1
        }
    }
    return sArr.concatToString()
}