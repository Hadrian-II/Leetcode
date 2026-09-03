package leetcode

fun main() {

}

class Node138(var `val`: Int) {
     var left: Node138? = null
     var right: Node138? = null
     var next: Node138? = null
     var random: Node138? = null
}

fun copyRandomList(node: Node138?): Node138? {
    if (node == null) {
        return null
    }
    val nodeMap = HashMap<Node138, Node138>()
    var current = node
    while (current != null) {
        nodeMap[current] = Node138(current.`val`)
        current = current.next
    }
    current = node
    while (current != null) {
        current.next?.let { nodeMap[current]!!.next = nodeMap[it] }
        current.random?.let { nodeMap[current]!!.random = nodeMap[it] }
        current = current.next
    }

    return nodeMap[node]
}