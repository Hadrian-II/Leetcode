package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(canFinish(2, readArrayOfArrays("[[1,0]]")))
    println(canFinish(2, readArrayOfArrays("[[1,0],[0,1]]")))
    println(canFinish(20, readArrayOfArrays("[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]")))
    println(canFinish(3, readArrayOfArrays("[[0,1],[0,2],[1,2]]")))
    println(canFinish(8, readArrayOfArrays("[[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]")))
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    var changed = true
    val currentMap = prerequisites.groupBy({ it[0] }, {it[1]}).toMutableMap()

    while (changed) {
        changed = false
        val ok = mutableListOf<Int>()
        for (entry in currentMap) {
            var blocked = false
            for (pre in entry.value) {
                if (pre in currentMap) {
                    blocked = true
                    break
                }
            }
            if (!blocked) {
                changed = true
                ok.add(entry.key)
            }
        }
        for (key in ok) {
            currentMap.remove(key)
        }
    }
    return currentMap.isEmpty()
}