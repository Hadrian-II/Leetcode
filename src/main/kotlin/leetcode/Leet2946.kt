package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(areSimilar(readArrayOfArrays("[[1,2,3],[4,5,6],[7,8,9]]"), 4))
    println(areSimilar(readArrayOfArrays("[[1,2,1,2],[5,5,5,5],[6,3,6,3]]"), 2))
    println(areSimilar(readArrayOfArrays("[[2,2],[2,2]]"), 3))
}

fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
    val shiftDistance = k % mat.first().size
    var even = true
    for (m in mat) {
        for (i in m.indices) {
            var target: Int
            if (even) {
                target = i - shiftDistance
                if (target < 0) {
                    target += m.size
                }

            } else {
                target = i + shiftDistance
                if (target > m.lastIndex) {
                    target -= m.size
                }
            }
            if (m[i] != m[target]) {
                return false
            }
        }
        even = !even
    }
    return true
}