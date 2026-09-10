package leetcode

import kotlin.math.min

fun main() {
    println(findContentChildren(intArrayOf(1,2,3), intArrayOf(1,1)))
    println(findContentChildren(intArrayOf(1,2), intArrayOf(1,2,3)))
}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var result = 0
    var iKid = 0
    var iCookie = 0
    while (iKid < g.size && iCookie < s.size) {
        val kid = g[iKid++]
        var cookie = s[iCookie++]

        while (kid > cookie) {
            if (iCookie == s.size) {
                return result
            } else {
                cookie = s[iCookie++]
            }
        }
        result++
    }
    return result
}