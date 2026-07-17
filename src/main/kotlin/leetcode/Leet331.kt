package leetcode

fun main() {
    println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
    println(isValidSerialization("1,#"))
    println(isValidSerialization("7,2,#,2,#,#,#,6,#"))
}

fun isValidSerialization(preorder: String): Boolean {
    if (preorder.startsWith('#')) {
        return preorder.length == 1
    }

    var open = 1
    var i = 0
    while (i <= preorder.lastIndex) {
        if (open == 0) {
            return false
        }
        if (preorder[i] == '#') {
            open--
            i += 2
        } else {
            open++
            while (i <= preorder.lastIndex && preorder[i] != ',') {
                i++
            }
            i++
        }
    }
    return open == 0
}