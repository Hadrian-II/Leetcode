package leetcode

import java.util.PriorityQueue

fun main() {
    val mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    println(mf.findMedian())
    mf.addNum(3)
    println(mf.findMedian())

    val mf2 = MedianFinder()
    mf2.addNum(6)
    println(mf2.findMedian())
    mf2.addNum(10)
    println(mf2.findMedian())
    mf2.addNum(2)
    println(mf2.findMedian())
    mf2.addNum(6)
    println(mf2.findMedian())
    mf2.addNum(5)
    println(mf2.findMedian())
    mf2.addNum(0)
    println(mf2.findMedian())
    mf2.addNum(6)
    println(mf2.findMedian())
    mf2.addNum(3)
    println(mf2.findMedian())
    mf2.addNum(1)
    println(mf2.findMedian())
    mf2.addNum(0)
    println(mf2.findMedian())
    mf2.addNum(0)
    println(mf2.findMedian())

    val mf3 = MedianFinder()
    mf3.addNum(1)
    println(mf3.findMedian())
    mf3.addNum(2)
    println(mf3.findMedian())
    mf3.addNum(3)
    println(mf3.findMedian())
    mf3.addNum(4)
    println(mf3.findMedian())
    mf3.addNum(5)
    println(mf3.findMedian())


    val mf4 = MedianFinder()
    mf4.addNum(5)
    println(mf4.findMedian())
    mf4.addNum(4)
    println(mf4.findMedian())
    mf4.addNum(3)
    println(mf4.findMedian())
    mf4.addNum(2)
    println(mf4.findMedian())
    mf4.addNum(1)
    println(mf4.findMedian())
}

class MedianFinder() {
    val low = PriorityQueue<Int>(compareByDescending { it })
    val high = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (low.isEmpty() || num <= low.peek()) {
            low.add(num)
        } else {
            high.add(num)
        }
        if (high.size > low.size) {
            low.add(high.poll())
        } else if (low.size > high.size + 1) {
            high.add(low.poll())
        }
    }

    fun findMedian(): Double {
        return if ((low.size + high.size) % 2 == 1) {
            low.peek().toDouble()
        } else {
            (low.peek().toDouble() + high.peek().toDouble()) / 2
        }
    }
}