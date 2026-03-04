package leetcode

fun main() {
    println(intToRoman(3749))
    println(intToRoman(58))
    println(intToRoman(1994))
}

fun intToRoman(num: Int): String {
    var left = num
    val thousands = "M".repeat(left / 1000)
    left = left % 1000
    val hundreds = when {
        left >= 900 -> "CM"
        left >= 800 -> "DCCC"
        left >= 700 -> "DCC"
        left >= 600 -> "DC"
        left >= 500 -> "D"
        left >= 400 -> "CD"
        left >= 300 -> "CCC"
        left >= 200 -> "CC"
        left >= 100 -> "C"
        else -> ""
    }
    left %= 100
    val tens = when {
        left >= 90 -> "XC"
        left >= 80 -> "LXXX"
        left >= 70 -> "LXX"
        left >= 60 -> "LX"
        left >= 50 -> "L"
        left >= 40 -> "XL"
        left >= 30 -> "XXX"
        left >= 20 -> "XX"
        left >= 10 -> "X"
        else -> ""
    }
    left %= 10
    val ones = when {
        left >= 9 -> "IX"
        left >= 8 -> "VIII"
        left >= 7 -> "VII"
        left >= 6 -> "VI"
        left >= 5 -> "V"
        left >= 4 -> "IV"
        left >= 3 -> "III"
        left >= 2 -> "II"
        left >= 1 -> "I"
        else -> ""
    }
    return thousands + hundreds + tens + ones
}