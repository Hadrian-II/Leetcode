package leetcode

import helpers.readListOfListsStr
import kotlin.time.measureTime

fun main() {
    println(Solution332().findItinerary(readListOfListsStr("[[\"MUC\",\"LHR\"],[\"JFK\",\"MUC\"],[\"SFO\",\"SJC\"],[\"LHR\",\"SFO\"]]")))
    println(Solution332().findItinerary(readListOfListsStr("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]")))
    println(measureTime {
        println(Solution332().findItinerary(readListOfListsStr("[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"JFK\"],[\"ATL\",\"AAA\"],[\"AAA\",\"ATL\"],[\"ATL\",\"BBB\"],[\"BBB\",\"ATL\"],[\"ATL\",\"CCC\"],[\"CCC\",\"ATL\"],[\"ATL\",\"DDD\"],[\"DDD\",\"ATL\"],[\"ATL\",\"EEE\"],[\"EEE\",\"ATL\"],[\"ATL\",\"FFF\"],[\"FFF\",\"ATL\"],[\"ATL\",\"GGG\"],[\"GGG\",\"ATL\"],[\"ATL\",\"HHH\"],[\"HHH\",\"ATL\"],[\"ATL\",\"III\"],[\"III\",\"ATL\"],[\"ATL\",\"JJJ\"],[\"JJJ\",\"ATL\"],[\"ATL\",\"KKK\"],[\"KKK\",\"ATL\"],[\"ATL\",\"LLL\"],[\"LLL\",\"ATL\"],[\"ATL\",\"MMM\"],[\"MMM\",\"ATL\"],[\"ATL\",\"NNN\"],[\"NNN\",\"ATL\"]]")))
    })
    println(Solution332().findItinerary(readListOfListsStr("[[\"JFK\",\"KUL\"],[\"JFK\",\"NRT\"],[\"NRT\",\"JFK\"]]")))
    println(Solution332().findItinerary(readListOfListsStr("[[\"DRW\",\"HBA\"],[\"EZE\",\"DRW\"],[\"ANU\",\"EZE\"],[\"AXA\",\"EZE\"],[\"DRW\",\"HBA\"],[\"ANU\",\"SYD\"],[\"EZE\",\"ANU\"],[\"CNS\",\"DRW\"],[\"HBA\",\"BNE\"],[\"JFK\",\"CNS\"],[\"BNE\",\"EZE\"],[\"HBA\",\"EZE\"],[\"EZE\",\"AXA\"],[\"ANU\",\"TIA\"],[\"CNS\",\"ANU\"],[\"ADL\",\"CNS\"],[\"TIA\",\"ANU\"],[\"EZE\",\"ADL\"]]")))
}

class Solution332 {
    class Node(val name: String) {
        var connections = mutableListOf<Pair<Int, Node>>()
        val roundTrips = mutableMapOf<String, MutableList<List<String>>>()
        val roundTripIds = mutableListOf<Int>()
        var inbound = 0

        fun findRoundTrips() {
            val newConnections = mutableListOf<Pair<Int, Node>>()
            val roundtripList = mutableListOf<List<String>>()
            for (connection in connections) {
                val destination = connection.second
                if (destination.connections.size == 1 &&
                    destination.connections[0].second.name == name &&
                    destination.inbound == 1) {
                    roundtripList.add(listOf(name, destination.name))
                    roundTripIds.add(connection.first)
                    roundTripIds.add(destination.connections[0].first)
                } else {
                    newConnections.add(connection)
                }
            }
            if (roundtripList.isNotEmpty()) {
                connections = newConnections
                roundtripList.sortByDescending { it[1] }
                val destinations = connections.map { it.second.name }.distinct().sorted().iterator()
                var destination = ""
                roundTrips[""] = mutableListOf()
                for (roundTrip in roundtripList) {
                    while (roundTrip[1] > destination && destinations.hasNext()) {
                        destination = destinations.next()
                        roundTrips[destination] = mutableListOf()
                    }
                    if (roundTrip[1] < destination || !destinations.hasNext()) {
                        roundTrips[destination]!!.add(roundTrip)
                    } else {
                        roundTrips[""]!!.add(roundTrip)
                    }
                }
            }
        }

        override fun toString(): String {
            return name
        }
    }
    val nodes = mutableMapOf<String, Node>()

    fun findItinerary(tickets: List<List<String>>): List<String> {
        for (i in tickets.indices) {
            val (from, to) = tickets[i]
            val fromNode = nodes.getOrPut(from) { Node(from) }
            val toNode = nodes.getOrPut(to) { Node(to) }
            fromNode.connections.add(Pair(i,toNode))
            toNode.inbound += 1
        }

        nodes.values.forEach { it.findRoundTrips() }

        return flyAround(nodes["JFK"]!!, BooleanArray(tickets.size))!!.reversed()
    }

    fun flyAround(node: Node, usedTickets: BooleanArray): MutableList<String>? {
        node.roundTripIds.forEach { usedTickets[it] = true }
        val availableDestinations = node.connections.filter { !usedTickets[it.first] }.sortedBy { it.second.name }
        if (availableDestinations.isEmpty()) {
            return if (usedTickets.all { it }) {
                val result = mutableListOf<String>()
                for (roundtrip in node.roundTrips.getOrDefault("", emptyList())) {
                    result.addAll(roundtrip)
                }
                result.add(node.name)
                result
            } else {
                null
            }
        } else {
            for ((id, destination) in availableDestinations) {
                val newTickets = usedTickets.copyOf()
                newTickets[id] = true

                val voyage = flyAround(destination, newTickets)

                if (voyage != null) {
                    for (roundTrip in node.roundTrips.getOrDefault(destination.name, emptyList())) {
                        voyage.addAll(roundTrip)
                    }

                    voyage.add(node.name)
                    return voyage
                }
            }
        }
        return null
    }
}