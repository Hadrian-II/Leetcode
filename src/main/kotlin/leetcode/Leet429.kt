package leetcode

fun main() {

}

//class Solution429 {
//    val result = mutableListOf(mutableListOf<Int>())
//
//    fun levelOrder(root: Node138?): List<List<Int>> {
//        if (root == null) {
//            return emptyList()
//        }
//
//        travel(root, 0)
//
//        return result
//    }
//
//    fun travel(node: Node138, level: Int) {
//        if (result.size <= level) {
//            result.add(mutableListOf(node.`val`))
//        } else {
//            result[level].add(node.`val`)
//        }
//
//        node.children.forEach { travel(it!!, level + 1) }
//    }
//}