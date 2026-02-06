package leetcode

fun main() {
    println(detectCapitalUse("USA"))
    println(detectCapitalUse("FlaG"))
}

fun detectCapitalUse(word: String): Boolean {
    if (word.length == 1) {
        return true
    }

    val notCapital = 'a'.code
    val startsCapital = word[0].code < notCapital
    val secondCapital = word[1].code < notCapital
    val needsCapital = if (startsCapital) {
        secondCapital
    } else {
        if (secondCapital) {
            return false
        }
        false
    }

    if (word.length > 2) {
        for (letter in word.substring(2)) {
            if (letter.code < notCapital != needsCapital) {
                return false
            }
        }
    }

    return true
}