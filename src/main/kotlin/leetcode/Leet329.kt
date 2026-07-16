package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(Solution329().longestIncreasingPath(readArrayOfArrays("[[9,9,4],[6,6,8],[2,1,1]]")))
    println(Solution329().longestIncreasingPath(readArrayOfArrays("[[3,4,5],[3,2,6],[2,2,1]]")))
}

class Solution329 {
    class Node(val value: Int) {
        val neighbours = mutableListOf<Node>()
        var steps = 1
        var touched = false
    }

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val nodes = Array(matrix.size) { x -> Array(matrix[0].size) { y -> Node(matrix[x][y])} }
        val lastY = nodes.first().lastIndex

        for (x in nodes.indices) {
            val line = nodes[x]
            val nextLine = if (x < nodes.lastIndex) nodes[x + 1] else null
            for (y in 0..lastY) {
                val curr = line[y]
                val nLine = if (y < lastY) line[y + 1] else null
                val nColumn = nextLine?.get(y)
                if (nLine != null) {
                    if (nLine.value > curr.value) {
                        curr.neighbours.add(nLine)
                    } else if (curr.value > nLine.value) {
                        nLine.neighbours.add(curr)
                    }
                }
                if (nColumn != null) {
                    if (nColumn.value > curr.value) {
                        curr.neighbours.add(nColumn)
                    } else if (curr.value > nColumn.value) {
                        nColumn.neighbours.add(curr)
                    }
                }
            }
        }

        for (x in nodes.indices) {
            for (y in nodes.first().indices) {
                val node = nodes[x][y]
                if (!node.touched) {
                    processNode(node)
                }
            }
        }

        return nodes.maxOf { it.maxOf { it.steps } }
    }

    fun processNode(node: Node) {
        for (neighbour in node.neighbours) {
            if (neighbour.steps <= node.steps) {
                neighbour.steps = node.steps + 1
                processNode(neighbour)
            }
        }
        node.touched = true
    }
}