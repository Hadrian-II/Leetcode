package leetcode

fun main() {

}
 class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

fun flatten(root: Node?): Node? {
    if (root == null) {
        return null
    }

    val nextStack = ArrayDeque<Node>()
    var current = root!!
    while (true) {
        while (current.child != null) {
            if (current.next != null) {
                nextStack.add(current.next!!)
            }
            current.next = current.child
            current.next!!.prev = current
            current.child = null
            current = current.next!!
        }

        if (current.next != null) {
            current = current.next!!
        } else if (nextStack.isNotEmpty()) {
            val next = nextStack.removeLast()
            current.next = next
            next.prev = current
            current = next
        } else {
            break
        }
    }
    return root
}