package leetcode

fun main() {
    println(evalRPN(arrayOf("2","1","+","3","*")))
    println(evalRPN(arrayOf("4","13","5","/","+")))
    println(evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
}

fun evalRPN(tokens: Array<String>): Int {
    val numStack = ArrayDeque<Int>()
    for (token in tokens) {
        when (token) {
            "+" -> {
                numStack.add(numStack.removeLast() + numStack.removeLast())
            }
            "-" -> {
                val last = numStack.removeLast()
                numStack.add(numStack.removeLast() - last)
            }
            "*" -> {
                numStack.add(numStack.removeLast() * numStack.removeLast())
            }
            "/" -> {
                val last = numStack.removeLast()
                numStack.add(numStack.removeLast() / last)
            }
            else -> {
                numStack.add(token.toInt())
            }
        }
    }
    return numStack.first()
}