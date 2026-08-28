package leetcode

fun main() {
    println(fizzBuzz(3))
    println(fizzBuzz(5))
    println(fizzBuzz(15))
}

fun fizzBuzz(n: Int): List<String> {
    val result = ArrayList<String>(n)
    for (nr in 1..n)  {
        result.add(if (nr % 3 == 0) {
            if (nr % 5 == 0) {
                "FizzBuzz"
            } else {
                "Fizz"
            }
        } else if (nr % 5 == 0) {
            "Buzz"
        } else {
            nr.toString()
        })
    }
    return result
}