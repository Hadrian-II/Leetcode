package leetcode

import java.util.Stack

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([])"))
    println(isValid("([)]"))
    println(isValid("]"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    for (c in s) {
        when (c) {
            '(', '[', '{' -> stack.push(c)
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
        }
    }

    return stack.isEmpty()
}