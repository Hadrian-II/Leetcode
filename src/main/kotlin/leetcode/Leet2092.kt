package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(findAllPeople(6, readArrayOfArrays("[[1,2,5],[2,3,8],[1,5,10]]"), 1))
    println(findAllPeople(4, readArrayOfArrays("[[3,1,3],[1,2,2],[0,3,3]]"), 3))
    println(findAllPeople(5, readArrayOfArrays("[[3,4,2],[1,2,1],[2,3,1]]"), 1))
    println(findAllPeople(11, readArrayOfArrays("[[5,1,4],[0,4,18]]"), 1))
}

fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val knowledge = HashSet<Int>()
    knowledge.add(0)
    knowledge.add(firstPerson)
    val timetable = meetings.groupBy( { it[2] },{ Pair(it[0], it[1]) })
    for (time in timetable.keys.sorted()) {
        val meetings = timetable[time]!!
        while (true) {
            val shares = meetings.filter { it.first in knowledge && it.second !in knowledge ||
                                           it.second in knowledge && it.first !in knowledge }
            for (share in shares) {
                knowledge.add(share.first)
                knowledge.add(share.second)
            }
            if (shares.isEmpty()) {
                break
            }
        }
    }
    return knowledge.toList()
}