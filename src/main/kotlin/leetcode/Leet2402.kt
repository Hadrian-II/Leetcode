package leetcode

import helpers.readArrayOfArrays
import java.io.File
import kotlin.Int
import kotlin.collections.ArrayDeque
import kotlin.math.max
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    // 0
    println(Solution2402().mostBooked(2, readArrayOfArrays("[[0,10],[1,5],[2,7],[3,4]]")))
    // 1
    println(Solution2402().mostBooked(3, readArrayOfArrays("[[1,20],[2,10],[3,5],[4,9],[6,8]]")))
    // 0
    println(Solution2402().mostBooked(5, readArrayOfArrays("[[40,47],[7,16],[27,38],[16,43],[38,40],[2,25]]")))
    // 15
    println(measureTime { println(Solution2402().mostBooked(100, readArrayOfArrays(File("src/main/kotlin/leetcode/input2402_71").readText()))) })
    // 1
    println(Solution2402().mostBooked(10, readArrayOfArrays(File("src/main/kotlin/leetcode/input2402_80").readText())))
}

class Solution2402 {
    lateinit var rooms: Array<Int>
    lateinit var roomMeetings: Array<Int>

    val OCCUPIED = Int.MAX_VALUE
    val ETERNITY = Int.MIN_VALUE
    val waiting = ArrayDeque<Int>()
    var freeRoom = 0
    var lowestLeft = Int.MAX_VALUE

    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val starts = meetings.map{ it[0] to it[1] - it[0] }.sortedBy { it.first }

        rooms = Array(n) { 0 }
        roomMeetings = Array(n) { 0 }


        var time = 0
        var deltaWait = 0
        for (i in starts.indices) {
            val delta = starts[i].first - time
            deltaWait = delta
            time += delta
            deltaWait = moveQueue(deltaWait)
            moveRoomTime(deltaWait)
            if (freeRoom != OCCUPIED) {
                startMeeting(starts[i].second)
            } else {
                waiting.addLast(starts[i].second)
            }
        }
        moveQueue(ETERNITY)

        return roomMeetings.indexOf(roomMeetings.max())
    }

    private fun moveQueue(deltaWait: Int): Int {
        var deltaWait1 = deltaWait
        while (waiting.isNotEmpty() && (deltaWait1 > 0 || deltaWait1 == ETERNITY)) {
            if (deltaWait1 == ETERNITY || lowestLeft <= deltaWait1) {
                if (deltaWait1 != ETERNITY) {
                    deltaWait1 -= lowestLeft
                }
                moveRoomTime(lowestLeft)
                startMeeting(waiting.removeFirst())
            } else {
                break
            }
        }
        return deltaWait1
    }

    fun startMeeting(meeting: Int) {
        rooms[freeRoom] = meeting
        roomMeetings[freeRoom]++
        getFreeRoom()
    }

    fun moveRoomTime(time: Int) {
        lowestLeft = Int.MAX_VALUE
        for (i in rooms.indices) {
            if (rooms[i] > 0) {
                val newVal = max(0, rooms[i] - time)
                rooms[i] = newVal
                lowestLeft = min(lowestLeft, newVal)
                if (i < freeRoom && newVal == 0) {
                    freeRoom = i
                }
            }
        }
    }

    fun getFreeRoom() {
        lowestLeft = Int.MAX_VALUE
        for (i in rooms.indices) {
            lowestLeft = min(lowestLeft, rooms[i])
            if (rooms[i] == 0) {
                freeRoom = i
                return
            }
        }
        freeRoom = OCCUPIED
    }
}