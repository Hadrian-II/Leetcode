package leetcode

fun main() {
    println(multiply("2", "3"))
    println(multiply("123", "456"))
    println(multiply("123456789", "987654321"))
}

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }
    val results = mutableListOf<List<Int>>()
    var shift = 0
    val n2 = num2.reversed().map { it.digitToInt() }
    for (n in num1.reversed().map { it.digitToInt() }) {
        var takeover = 0
        val curr = MutableList(shift) {0}
        for (m in n2) {
            val number = n * m + takeover
            curr.add(number % 10)
            takeover = number / 10
        }
        if (takeover != 0) {
            curr.add(takeover)
        }
        results.add(curr)
        shift++
    }

    val result = StringBuilder()
    var running = true
    var i = 0
    var takeover = 0
    while (running) {
        running = false
        var sum = takeover
        for (r in results) {
            if (r.size > i) {
                running = true
                sum += r[i]
            }
        }
        if (running) {
            result.append(sum % 10)
            takeover = sum / 10
            i++
        }
    }

    if (takeover != 0) {
        result.append(takeover)
    }

    return result.reversed().toString()
}