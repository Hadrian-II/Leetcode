package helpers

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}

fun createList(numbers: IntArray): ListNode {
    val first = ListNode(numbers[0])
    if (numbers.size > 1) {
        var current = first
        for (i in 1..numbers.lastIndex) {
            val new = ListNode(numbers[i])
            current.next = new
            current = new
        }
    }
    return first
}

fun printList(head: ListNode?) {
    var str = ""
    var current = head
    while (current != null) {
        str += current.`val`.toString() + ", "
        current = current.next

    }
    println(str)
}

fun printIntArray(array: IntArray) {
    println(array.joinToString(",") { it.toString() })
}

fun printDoubleArray(array: DoubleArray) {
    println(array.joinToString(",") { it.toString() })
}

fun readInput(input: String): Array<IntArray> {
    return Regex("\\[-?\\d+,-?\\d+]").findAll(input)
        .map { it.value.substring(1, it.value.length - 1).split(",") }
        .map { intArrayOf(it[0].toInt(), it[1].toInt())}.toList().toTypedArray()
}

fun readArrayOfArrays(input: String): Array<IntArray> {
    return input.trim('[').trim(']').split("],[")
                .map { it.split(',').map { n -> n.toInt() }.toIntArray() }.toTypedArray()
}

fun readArrayOfCharArrays(input: String): Array<CharArray> {
    return input.trim('[').trim(']').split("],[")
        .map { it.split(',').joinToString("") { inner -> inner.trim('"') }.toCharArray() }.toTypedArray()
}

fun readListOfListsStr(input: String): List<List<String>> {
    return input.trim('[').trim(']').split("],[")
        .map { it.split(',').map { inner -> inner.trim('"')} }
}

fun readListOfLists(input: String): List<List<Int>> {
    return input.trim('[').trim(']').split("],[")
                .map { it.split(',').mapNotNull { n -> n.toIntOrNull() } }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}

fun treeFactory(raw: String): TreeNode {
    val input = raw.split(',').map { if (it == "null") null else it.toInt() }
    return createNode( input)
}

fun createNode(data: List<Int?>): TreeNode {
    val node = TreeNode(data[0]!!)
    val leaves = ArrayDeque<TreeNode>()
    leaves.add(node)
    for (i in 1..data.lastIndex step 2) {
        val parent = leaves.removeFirst()
        if (data[i] != null) {
            val leftNode = TreeNode(data[i]!!)
            parent.left = leftNode
            leaves.add(leftNode)
        }
        if (i + 1 <= data.lastIndex && data[i + 1] != null) {
            val rightNode = TreeNode(data[i + 1]!!)
            parent.right = rightNode
            leaves.add(rightNode)
        }
    }
    return node
}
