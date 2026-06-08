package leetcode

import java.util.Stack
import kotlin.math.min

fun main() {
//    val s = MinStack()
//    s.push(-2)
//    s.push(0)
//    s.push(-3)
//    println(s.getMin())
//    s.pop()
//    println(s.top())
//    println(s.getMin())

    val s2 = MinStack()
    s2.push(6) // 6
    s2.push(6) // 6 6
    s2.push(7) // 6 6 7
    println(s2.top())
    s2.pop()        // 6 6
    println(s2.getMin())
    s2.pop()        // 6
    println(s2.getMin())
    s2.pop()        //
    s2.push(7) // 6
    println(s2.top())
    println(s2.getMin())
    s2.push(-7) // 6 -7
    println(s2.top())
    println(s2.getMin())
    s2.pop() // 6
    println(s2.getMin())
}

class MinStack() {
    var minimum = Int.MAX_VALUE
    val stack = Stack<Pair<Int, Int>>()

    fun push(`val`: Int) {
        stack.push(Pair(`val`, minimum))
        minimum = min(`val`, minimum)
    }

    fun pop() {
        minimum = stack.pop().second
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return minimum
    }
}