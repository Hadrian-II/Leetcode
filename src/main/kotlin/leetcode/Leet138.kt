package leetcode

fun main() {

}

class Node(var `val`: Int) {
     var left: Node? = null
     var right: Node? = null
     var next: Node? = null
     var random: Node? = null
}

fun copyRandomList(node: Node?): Node? {
    if (node == null) {
        return null
    }
    val nodeMap = HashMap<Node, Node>()
    var current = node
    while (current != null) {
        nodeMap[current] = Node(current.`val`)
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