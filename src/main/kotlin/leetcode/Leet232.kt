package leetcode

import java.util.Stack

fun main() {
    val a = MyQueue()
    a.push(1)
    a.push(2)
    println(a.peek())
    println(a.pop())
    println(a.empty())

    println(a.pop())
    println(a.empty())
}

class MyQueue() {
    val input = Stack<Int>()
    val output = Stack<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        shift()
        return output.pop()
    }

    fun peek(): Int {
        shift()
        return output.peek()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }

    private fun shift() {
        if (output.isEmpty()) {
            while (input.isNotEmpty()) {
                output.push(input.pop())
            }
        }
    }
}