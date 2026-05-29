package leetcode

class Solution133 {
    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }


    val clones = Array<Node?>(101) { null }
    val processed = Array(101) { false }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        cloneNodes(node)
        mapNodes(node)

        return clones[node.`val`]
    }

    private fun cloneNodes(node: Node) {
        if (clones[node.`val`] == null) {
            clones[node.`val`] = Node(node.`val`)
            for (neighbor in node.neighbors) {
                cloneNodes(neighbor!!)
            }
        }
    }

    private fun mapNodes(node: Node) {
        if (!processed[node.`val`]) {
            processed[node.`val`] = true

            val clone = clones[node.`val`]!!
            for (neighbor in node.neighbors) {
                clone.neighbors.add(clones[neighbor!!.`val`])
                mapNodes(neighbor)
            }
        }
    }
}