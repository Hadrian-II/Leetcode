package leetcode

fun main() {

}

class Solution116 {
    val nextRights = mutableMapOf<Int, Node138>()

    fun connect(root: Node138?): Node138? {
        if (root != null) {
            map(root, 0)
        }

        return root
    }

    fun map(node: Node138, level: Int) {
        if (node.left != null) {
            if (nextRights[level] != null) {
                node.right!!.next = nextRights[level]
            }
            node.left!!.next = node.right
            nextRights[level] = node.left!!
            map(node.right!!, level + 1)
            map(node.left!!, level + 1)
        }
    }
}