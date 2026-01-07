package leetcode

import helpers.readListOfLists

fun main() {
    println(canVisitAllRooms(readListOfLists("[[1],[2],[3],[]]")))
    println(canVisitAllRooms(readListOfLists("[[1,3],[3,0,1],[2],[0]]")))
}

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val roomOpen = Array(rooms.size) { false }
    roomOpen[0] = true
    var newlyOpened = ArrayList<Int>()
    newlyOpened.add(0)
    while (newlyOpened.isNotEmpty()) {
        val opened = ArrayList<Int>()
        for (room in newlyOpened) {
            for (key in rooms[room]) {
                if (!roomOpen[key]) {
                    roomOpen[key] = true
                    opened.add(key)
                }
            }
        }
        newlyOpened = opened
    }
    return roomOpen.all { it }
}