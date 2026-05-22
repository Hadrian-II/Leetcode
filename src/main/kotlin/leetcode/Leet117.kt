package leetcode

class Solution117 {
    val nextRights = mutableMapOf<Int, Node>()

    fun connect(root: Node?): Node? {
        if (root != null) {
            map(root, 0)
        }

        return root
    }

    fun map(node: Node, level: Int) {
        if (node.left != null || node.right != null) {
            if (nextRights[level] != null) {
                if (node.right != null) {
                    node.right!!.next = nextRights[level]
                } else {
                    node.left!!.next = nextRights[level]
                }
            }
            if (node.left != null && node.right != null) {
                node.left!!.next = node.right
            }
            if (node.left != null) {
                nextRights[level] = node.left!!
            } else {
                nextRights[level] = node.right!!
            }
        }
        node.right?.let { map(it, level + 1) }
        node.left?.let { map(it, level + 1) }
    }
}