package leetcode

import helpers.readArrayOfArrays
import kotlin.math.max
import kotlin.math.pow

fun main() {
    println(Solution3558().assignEdgeWeights(readArrayOfArrays("[[1,2]]")))
    println(Solution3558().assignEdgeWeights(readArrayOfArrays("[[1,2],[1,3],[3,4],[3,5]]")))
}

class Solution3558 {
    class Node() {
        val neighbours = mutableListOf<Node>()
        var depth = -1
    }
    val nodes = HashMap<Int, Node>()
    var maxDepth = 0

    fun assignEdgeWeights(edges: Array<IntArray>): Int {
        for ((first, second) in edges) {
            val firstNode = getOrCreateNode(first)
            val secondNode = getOrCreateNode(second)
            firstNode.neighbours.add(secondNode)
            secondNode.neighbours.add(firstNode)
        }

        val start = nodes[1]!!
        start.depth = 0
        traverse(start)

        var result = 1
        var i = 1
        while (i < maxDepth) {
            result *= 2
            result %= 1000000007
            i++
        }

        return result
    }

    fun getOrCreateNode(id: Int): Node {
        if (id !in nodes) {
            nodes[id] = Node()
        }
        return nodes[id]!!
    }

    fun traverse(node: Node) {
        for (neighbour in node.neighbours) {
            if (neighbour.depth == -1) {
                neighbour.depth = node.depth + 1
                maxDepth = max(maxDepth, neighbour.depth)
                traverse(neighbour)
            }
        }
    }
}