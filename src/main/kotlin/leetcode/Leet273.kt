package leetcode

fun main() {
    println(numberToWords(123))
    println(numberToWords(12345))
    println(numberToWords(1234567))
    println(numberToWords(10))
    println(numberToWords(9))
    println(numberToWords(100))
    println(numberToWords(1000000))
}

fun numberToWords(num: Int): String {
    if (num == 0) {
        return "Zero"
    }

    val billion = 1_000_000_000
    val million = 1_000_000
    var number = num
    val builder = mutableListOf<String>()

    if (number >= billion) {
        belowThousand(num / billion, builder)
        builder.add("Billion")
        number %= billion
    }

    if (number >= million) {
        belowThousand(number / million, builder)
        builder.add("Million")
        number %= million
    }

    if (number >= 1000) {
        belowThousand(number / 1000, builder)
        builder.add("Thousand")
        number %= 1000
    }

    belowThousand(number, builder)

    return builder.joinToString(" ")
}

fun belowThousand(num: Int, builder: MutableList<String>) {
    if (num > 99) {
        ones(num / 100, builder)
        builder.add("Hundred")
    }
    val belowHundred = num % 100

    if (belowHundred < 10) {
        ones(num % 10, builder)
    } else if (belowHundred < 20) {
        when (belowHundred) {
            10 -> builder.add("Ten")
            11 -> builder.add("Eleven")
            12 -> builder.add("Twelve")
            13 -> builder.add("Thirteen")
            14 -> builder.add("Fourteen")
            15 -> builder.add("Fifteen")
            16 -> builder.add("Sixteen")
            17 -> builder.add("Seventeen")
            18 -> builder.add("Eighteen")
            19 -> builder.add("Nineteen")
        }
    } else {
        tens(belowHundred / 10, builder)
        ones(belowHundred % 10, builder)
    }
}

fun tens(num: Int, builder: MutableList<String>) {
    when (num) {
        2 -> builder.add("Twenty")
        3 -> builder.add("Thirty")
        4 -> builder.add("Forty")
        5 -> builder.add("Fifty")
        6 -> builder.add("Sixty")
        7 -> builder.add("Seventy")
        8 -> builder.add("Eighty")
        9 -> builder.add("Ninety")
    }
}

fun ones(num: Int, builder: MutableList<String>) {
    when (num) {
        1 -> builder.add("One")
        2 -> builder.add("Two")
        3 -> builder.add("Three")
        4 -> builder.add("Four")
        5 -> builder.add("Five")
        6 -> builder.add("Six")
        7 -> builder.add("Seven")
        8 -> builder.add("Eight")
        9 -> builder.add("Nine")
    }
}