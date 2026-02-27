package leetcode

fun main() {
    println(numSteps("1101"))
    println(numSteps("10"))
    println(numSteps("1"))
    println(numSteps("11001"))
}

fun numSteps(s: String): Int {
    var steps = 0
    val bool = s.map { it == '1' }.toTypedArray()

    for (i in bool.indices.reversed()) {
        if (bool[i]) {
            if (i != 0) {
                steps += 2
                var j = i - 1
                while (j > 0) {
                    if (!bool[j]) {
                        bool[j] = true
                        break
                    }
                    j--
                }
                if (j == 0) {
                    steps += i
                    break
                }
            }
        } else {
            steps++
        }
    }

    return steps
}