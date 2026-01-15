package leetcode

import java.util.*

fun main() {
    var stockSpanner = StockSpanner()
    println(stockSpanner.next(100)) // return 1
    println(stockSpanner.next(80)) // return 1
    println(stockSpanner.next(60)) // return 1
    println(stockSpanner.next(70)) // return 2
    println(stockSpanner.next(60)) // return 1
    println(stockSpanner.next(75)) // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
    println(stockSpanner.next(85)) // return 6
    println(stockSpanner.next(85)) // return 7
    println("====")
    stockSpanner = StockSpanner()
    println(stockSpanner.next(31)) // return 1
    println(stockSpanner.next(41)) // return 2
    println(stockSpanner.next(48)) // return 3
    println(stockSpanner.next(59)) // return 4
    println(stockSpanner.next(79)) // return 5
    println("====")
    stockSpanner = StockSpanner()
    println(stockSpanner.next(28)) // return 1
    println(stockSpanner.next(14)) // return 1
    println(stockSpanner.next(28)) // return 3
    println(stockSpanner.next(35)) // return 4
    println(stockSpanner.next(46)) // return 5
    println(stockSpanner.next(53)) // return 6
    println(stockSpanner.next(66)) // return 7
    println(stockSpanner.next(80)) // return 8
    println(stockSpanner.next(87)) // return 9
    println(stockSpanner.next(88)) // return 10
    println("====")
    stockSpanner = StockSpanner()
    println(stockSpanner.next(5)) // return 1
    println(stockSpanner.next(56)) // return 1
    println(stockSpanner.next(66)) // return 3
    println(stockSpanner.next(91)) // return 4
    println(stockSpanner.next(71)) // return 5
    println(stockSpanner.next(72)) // return 6
    println(stockSpanner.next(75)) // return 7
    println(stockSpanner.next(69)) // return 8
    println(stockSpanner.next(95)) // return 9
    println(stockSpanner.next(94)) // return 10
    println("====")
    stockSpanner = StockSpanner()
    println(stockSpanner.next(3)) // return 1
    println(stockSpanner.next(4)) // return 2
    println(stockSpanner.next(21)) // return 3
    println(stockSpanner.next(69)) // return 4
    println(stockSpanner.next(29)) // return 1
    println(stockSpanner.next(35)) // return 2
    println(stockSpanner.next(98)) // return 7
    println(stockSpanner.next(46)) // return 1
    println(stockSpanner.next(50)) // return 2
    println(stockSpanner.next(53)) // return 3
    println(stockSpanner.next(58)) // return 4
    println(stockSpanner.next(59)) // return 5
    println(stockSpanner.next(69)) // return 6
    println(stockSpanner.next(98)) // return 14
    println(stockSpanner.next(69)) // return 1
    println(stockSpanner.next(73)) // return 2
    println(stockSpanner.next(74)) // return 3
    println(stockSpanner.next(41)) // return 1
    println(stockSpanner.next(27)) // return 1
    println(stockSpanner.next(78)) // return 6
}

class StockSpanner() {
    val minStack = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    var date = 0

    fun next(price: Int): Int {
        date++
        if (minStack.isEmpty() || minStack.peek().second > price ) {
            minStack.add(Pair(date, price))
            return 1
        } else {
            minStack.poll()
            while (minStack.isNotEmpty() && minStack.peek().second <= price) {
                minStack.poll()
            }
            val peek = minStack.peek()
            val res = date - (peek?.first ?: 0) + if (peek?.second == price) 1 else 0
            if (minStack.isEmpty() || price < peek.second) {
                minStack.add(Pair(date, price))
            }
            return res
        }
    }
}