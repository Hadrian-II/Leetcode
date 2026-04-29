package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(Solution1391().hasValidPath(readArrayOfArrays("[[2,4,3],[6,5,2]]")))
    println(Solution1391().hasValidPath(readArrayOfArrays("[[1,2,1],[1,2,1]]")))
}

class Solution1391 {
    enum class Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    val movement = mapOf(
        Direction.NORTH to Pair(-1, 0),
        Direction.EAST to Pair(0, 1),
        Direction.SOUTH to Pair(1, 0),
        Direction.WEST to Pair(0, -1)
    )

    lateinit var grid: Array<IntArray>

    fun hasValidPath(grid: Array<IntArray>): Boolean {
        this.grid = grid

        if (grid.size == 1 && grid[0].size == 1) {
            return true
        }

        if (grid[0][0] == 5) {
            return false
        }

        return getDirections(grid[0][0]).filter { it != Direction.WEST && it != Direction.NORTH }.any { findPath(it, 0, 0)}
    }

    fun flipDir(direction: Direction): Direction {
        return when(direction) {
            Direction.EAST -> Direction.WEST
            Direction.NORTH -> Direction.SOUTH
            Direction.WEST -> Direction.EAST
            Direction.SOUTH -> Direction.NORTH
        }
    }

    fun findPath(direction: Direction, fromX: Int, fromY: Int): Boolean {
        val mov = movement[direction]!!
        val newX = fromX + mov.first
        val newY = fromY + mov.second

        if (newX == 0 && newY == 0) {
            return false // circle
        }
        if (newX !in grid.indices || newY !in grid[0].indices) {
            return false
        }

        val newDirections = getDirections(grid[newX][newY])

        val flipped = flipDir(direction)
        if (flipped !in newDirections) {
            return false
        }
        if (newX == grid.lastIndex && newY == grid[0].lastIndex) {
            return true
        }

        return findPath(newDirections.first { it != flipped }, newX, newY)
    }

    fun getDirections(type: Int): List<Direction> {
        return when(type) {
            1 -> listOf(Direction.EAST, Direction.WEST)
            2 -> listOf(Direction.NORTH, Direction.SOUTH)
            3 -> listOf(Direction.WEST, Direction.SOUTH)
            4 -> listOf(Direction.EAST, Direction.SOUTH)
            5 -> listOf(Direction.WEST, Direction.NORTH)
            else -> listOf(Direction.EAST, Direction.NORTH)
        }
    }
}