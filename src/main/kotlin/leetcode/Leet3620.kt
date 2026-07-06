package leetcode

import helpers.readArrayOfArrays
import java.io.File
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
//    println(Solution3620().findMaxPathScore(
//        readArrayOfArrays("[[0,1,5],[1,3,10],[0,2,3],[2,3,4]]"),
//        booleanArrayOf(true,true,true,true),
//        10))
//
//    println(Solution3620().findMaxPathScore(
//        readArrayOfArrays("[[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]]"),
//        booleanArrayOf(true,true,true,false,true),
//        12))
//
//    println(Solution3620().findMaxPathScore(
//        readArrayOfArrays("[0,1,5],[0,1,0],[1,2,5]"),
//        booleanArrayOf(true,true,true),
//        10))
//
//    println(measureTime {
//    println(Solution3620().findMaxPathScore(
//        readArrayOfArrays("[[8,26,270],[6,29,907],[10,23,546],[0,8,146],[19,28,618],[3,13,256],[13,20,496],[28,29,804],[21,27,260],[17,26,348],[12,22,865],[0,18,99],[5,26,663],[16,19,209],[24,26,137],[20,25,562],[18,29,374],[17,25,165],[22,26,333],[6,15,71],[21,25,241],[17,29,448],[7,13,162],[18,19,721],[7,22,42],[14,16,69],[5,10,289],[0,10,427],[27,28,489],[23,26,154],[16,27,492],[9,13,499],[21,22,232],[15,27,6],[7,8,65],[18,21,530],[10,29,880],[25,28,629],[14,28,46],[4,20,134],[11,28,392],[4,26,564],[1,28,633],[4,7,906],[9,26,71],[6,19,252],[15,16,655],[16,20,61],[24,29,141],[18,24,934],[15,23,717],[26,29,301],[27,29,518],[3,22,369],[20,23,759],[10,22,640],[7,21,314],[17,21,335],[4,27,439],[2,14,132],[2,12,367],[21,26,509],[23,27,658],[25,29,597],[14,22,907],[2,9,898],[18,20,51],[1,22,11],[22,28,262],[26,27,436],[15,28,700],[0,20,740],[19,26,499],[14,27,789],[7,14,228],[1,12,318],[20,29,827],[25,26,812],[19,27,650],[9,16,940],[24,25,911],[7,27,640],[0,2,645],[18,26,866],[2,19,672],[20,28,486],[16,23,239],[2,28,773],[22,25,351],[0,3,957],[12,21,942],[9,10,76],[3,24,97],[22,27,662],[9,18,821],[24,27,509],[16,17,445],[1,13,983],[5,9,422],[25,27,797],[12,15,728],[0,6,408],[17,27,610],[5,17,669],[22,29,142],[21,29,759],[5,25,632],[6,26,538],[1,29,142],[20,26,450],[0,9,317],[20,21,18],[4,28,505],[7,20,406],[4,12,854],[14,20,951],[0,11,196],[19,24,97],[3,21,501],[20,22,246],[10,24,830],[11,25,989],[11,21,240],[3,19,828],[21,24,902],[0,25,442],[11,29,627],[11,24,677],[12,28,949],[26,28,743],[15,25,951],[10,11,517],[6,25,278],[19,20,382],[22,23,391],[16,25,393],[0,27,125],[23,28,447],[3,11,624],[10,25,655],[1,4,389],[10,20,336],[10,14,864],[0,17,412],[13,28,682],[3,6,220],[1,17,403],[19,22,514],[10,13,80],[11,17,587],[1,5,804],[11,26,728],[0,14,172],[7,17,957],[9,17,860],[2,18,549],[5,6,893],[9,14,404],[3,27,195],[16,29,649],[6,23,625],[6,27,417],[1,24,663],[6,16,434],[12,23,559],[12,18,844],[2,17,689],[11,23,973],[15,24,430],[0,7,639],[5,20,453],[7,28,364],[20,27,93],[0,28,866],[15,21,707],[22,24,627],[14,21,610],[7,26,740],[12,13,496],[1,18,880],[2,15,689],[4,14,415],[20,24,254],[4,17,175],[19,29,637],[18,27,945],[1,2,356],[9,22,390],[23,25,774],[13,15,833],[16,24,243],[1,27,586],[13,21,522],[12,26,789],[4,19,254],[6,22,809],[14,24,712],[12,20,855],[15,26,494],[11,18,461],[7,11,72],[9,24,489],[18,23,688],[7,9,532],[3,9,271],[8,28,457],[10,17,276],[11,19,815],[17,20,275],[2,29,818],[3,17,643],[2,26,405],[9,20,975],[13,19,797],[3,29,846],[13,26,548],[6,11,516],[8,24,311],[1,9,400],[7,12,895],[14,29,923],[21,23,284],[14,25,937],[2,4,65],[5,15,804],[16,26,428],[17,24,660],[3,18,722],[8,15,539],[12,19,672],[9,15,898],[4,21,288],[3,25,133],[10,15,452],[0,24,125],[6,18,786],[17,19,904],[8,22,883],[14,18,394],[17,23,754],[9,11,415],[0,16,55],[24,28,267],[11,14,807],[10,16,228],[23,24,47],[7,10,411],[12,25,896],[8,29,728],[14,19,110],[12,27,311],[23,29,652],[1,11,292],[5,21,549],[1,21,123],[7,24,566],[4,8,63],[16,18,73],[13,25,736],[9,19,923],[17,18,80],[11,22,50],[2,13,546],[16,22,875],[15,19,481],[12,29,457],[9,23,893],[0,26,332],[10,26,119],[8,27,806],[19,25,264],[3,5,422],[18,28,736],[8,13,315],[12,17,596],[7,15,940],[8,14,845],[8,11,956],[21,28,257],[2,16,354],[13,22,630],[10,12,918],[8,10,322],[15,29,872],[13,18,519],[8,20,918],[5,23,203],[10,27,693],[10,28,615],[0,21,490],[1,3,986],[19,21,116],[9,25,104],[1,19,456],[13,23,885],[15,18,377],[6,14,177],[11,13,383],[6,8,222],[15,22,894],[4,16,44],[3,12,885],[3,14,649],[2,5,208],[4,9,590],[4,29,321],[17,22,994],[0,1,750],[1,26,273],[13,29,42],[16,28,451],[18,25,393],[18,22,128],[19,23,277],[4,22,745],[3,4,730],[7,25,312],[6,9,910],[3,15,305],[2,25,779],[4,10,729],[1,14,172],[11,16,491],[8,17,86],[8,16,24],[6,12,234],[2,27,979],[3,20,207],[15,20,522],[9,12,713],[7,19,859],[8,12,964],[11,12,716],[2,22,601],[6,13,611],[13,16,717],[6,17,445],[1,20,895],[3,7,621],[4,23,944],[2,24,851],[17,28,842],[13,27,476],[8,25,549],[4,13,730],[3,8,561],[13,14,306],[4,25,603],[1,8,610],[0,13,729],[13,24,132],[4,5,259],[5,24,337],[14,17,308],[12,16,12],[8,19,321],[2,20,574],[6,21,409],[3,16,947],[5,11,175],[8,23,775],[6,24,501],[14,23,548]]"),
//        booleanArrayOf(true,true,true,true,true,true,true,false,false,false,false,false,true,true,true,true,true,true,true,true,false,true,true,true,true,false,false,true,true,true),
//        8925)) })

    println(measureTime {
        println(Solution3620().findMaxPathScore(
            readArrayOfArrays(File("src/main/kotlin/leetcode/input3620_636").readText()),
            BooleanArray(50000) { true },
            1874920239)) })
}

class Solution3620 {
    class Path(val distance: Int, val throughput: Int, var old: Boolean)

    class Node() {
        var outgoing = mutableMapOf<Int, MutableSet<Int>>()
        var incoming: MutableList<Path> = mutableListOf()

        fun addPath(distance: Int, throughput: Int) {
            incoming.add(Path(distance, throughput, false))
        }

        fun processPaths(): Boolean {
            if (incoming.size == 1) {
                incoming.forEach { it.old = true }
                return true
            }


            incoming.sortWith(compareBy<Path> { it.distance }.thenByDescending { it.throughput })

            val first = incoming[0]
            var bestThroughput = first.throughput
            val new = mutableListOf(first)
            for (i in 1..incoming.lastIndex) {
                val other = incoming[i]
                if (other.throughput > bestThroughput) {
                    new.add(other)
                    bestThroughput = other.throughput
                }
            }
            incoming = new
            val hasNew = incoming.any{ !it.old }
            incoming.forEach { it.old = true }
            return hasNew
        }
    }
    lateinit var nodes: Array<Node>
    var k = 0L

    fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        this.k = k
        nodes = Array(online.size) { Node() }
        nodes[0].incoming = mutableListOf(Path(0, Int.MAX_VALUE, true))

        for (edge in edges.filter { online[it[0]] && online[it[1]] }) {
            if (nodes[edge[0]].outgoing[edge[1]] == null) {
                nodes[edge[0]].outgoing[edge[1]] = mutableSetOf()
            }

            nodes[edge[0]].outgoing[edge[1]]!!.add(edge[2])
        }

        findPath(nodes[0])

        val incoming = nodes.last().incoming
        return if (incoming.isNotEmpty()) incoming.maxOf { it.throughput } else -1
    }

    fun findPath(node: Node) {
        val targets = mutableSetOf<Node>()
        for (connection in node.outgoing) {
            val target = nodes[connection.key]
            if (connection.key != nodes.lastIndex && target.outgoing.isEmpty()) {
                continue
            }
            for (incoming in node.incoming) {
                for (distance in connection.value) {
                    val sum = incoming.distance + distance
                    val throughput = min(incoming.throughput, distance)
                    if (sum <= k) {
                        target.addPath(sum, throughput)
                        targets.add(target)
                    }
                }
            }
        }
        for (target in targets) {
            if (target.processPaths()) {
                findPath(target)
            }
        }
    }
}
