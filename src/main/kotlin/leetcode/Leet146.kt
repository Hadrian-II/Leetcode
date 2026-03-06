package leetcode

import helpers.ListNode

fun main() {
    val c = LRUCache(2)
    c.put(1,1)
    c.put(2,2)
    println(c.get(1))
    c.put(3,3)
    println(c.get(2))
    c.put(4,4)
    println(c.get(1))
    println(c.get(3))
    println(c.get(4))
    println("----------")
    val d = LRUCache(2)
    d.put(2,1)
    d.put(2,2)
    println(d.get(2))
    d.put(1,1)
    d.put(4,1)
    println(d.get(2))
    val e = LRUCache(1)
    e.get(6)
    e.get(8)
    e.put(12,1)
    e.get(2)
    e.put(15,11)
    e.put(5,2)
    e.put(1,15)
    e.put(4,2)
    e.get(4)
    e.put(15,15)
}

class LRUCache(val capacity: Int) {
    val map = HashMap<Int, ListNode>()
    var newestKey: ListNode? = null
    var lastKey: ListNode? = null

    fun get(key: Int): Int {
        val current = map[key]
        return if (current != null) {
            moveFirst(current)
            return current.`val`
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        val current = map[key]
        if (current != null) {
            moveFirst(current)
            current.`val` = value
            newestKey = current
        } else {
            if (map.size == capacity) {
                val kill = lastKey
                map.remove(kill!!.anyVal)
                kill.previous?.next = null
                lastKey = lastKey!!.previous
                if (lastKey == null) {
                    newestKey = null
                }
            }
            val new = ListNode(value)
            new.anyVal = key
            if (newestKey == null) {
                lastKey = new
            } else {
                newestKey!!.previous = new
                new.next = newestKey
            }
            newestKey = new
            map[key] = new
        }
    }

    fun moveFirst(current: ListNode) {
        if (current != newestKey) {
            current.previous!!.next = current.next
            current.next?.previous = current.previous!!
            if (current.next == null) {
                lastKey = current.previous
            }
            current.previous = null
            newestKey!!.previous = current
            current.next = newestKey
            newestKey = current
        }
    }
}
