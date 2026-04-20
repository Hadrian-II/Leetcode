package leetcode

import java.util.Stack

fun main() {
    println(simplifyPath("/home/"))
    println(simplifyPath("/home//foo/"))
    println(simplifyPath("/home/user/Documents/../Pictures"))
    println(simplifyPath("/../"))
    println(simplifyPath("/.../a/../b/c/../d/./"))
}

fun simplifyPath(path: String): String {
    val dicts = Stack<String>()
    val current = StringBuilder()
    var i = 0
    while (i <= path.length) {
        val c = if (i == path.length) '/' else path[i]
        if (c == '/') {
            if (current.isNotEmpty()) {
                val dict = current.toString()
                if (dict == "..") {
                    if (dicts.isNotEmpty()) {
                        dicts.pop()
                    }
                } else if (dict != ".") {
                    dicts.add(dict)
                }
                current.clear()
            }
        } else {
            current.append(c)
        }
        i++
    }
    return "/" + dicts.joinToString("/")
}