package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(maxNumberOfFamilies(3, readArrayOfArrays("[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]")))
    println(maxNumberOfFamilies(2, readArrayOfArrays("[[2,1],[1,8],[2,6]]")))
    println(maxNumberOfFamilies(4, readArrayOfArrays("[[4,3],[1,4],[4,6],[1,7]]")))
    println(maxNumberOfFamilies(3, readArrayOfArrays("[[2,3]]")))
}

fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
    reservedSeats.sortBy { it[0] }
    var currentRow = 1
    var maxFamilies = 0
    val rowReservations = mutableListOf<Int>()

    for (reservation in reservedSeats) {
        if (reservation[0] != currentRow) {
            maxFamilies += (reservation[0] - currentRow - 1) * 2
            currentRow = reservation[0]
            maxFamilies += familiesInRow(rowReservations)
            rowReservations.clear()
        }
        if (reservation[1] != 1 && reservation[1] != 10) {
            rowReservations.add(reservation[1])
        }
    }
    maxFamilies += (n - currentRow) * 2
    maxFamilies += familiesInRow(rowReservations)
    return maxFamilies
}

fun familiesInRow(reserved: List<Int>): Int {
    var canLeft = true
    var canMiddle = true
    var canRight = true
    for (r in reserved) {
        if (canLeft && r in 2..5) {
            canLeft = false
        }
        if (canMiddle && r in 4..7) {
            canMiddle = false
        }
        if (canRight && r in 6..9) {
            canRight = false
        }
    }
    return if (canLeft) {
        if (canRight) 2 else 1
    } else {
        if (canMiddle || canRight) 1 else 0
    }
}