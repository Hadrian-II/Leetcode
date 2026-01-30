package leetcode

fun main() {
    println(countStudents(intArrayOf(1,1,0,0), intArrayOf(0,1,0,1)))
    println(countStudents(intArrayOf(1,1,1,0,0,1), intArrayOf(1,0,0,0,1,1)))
}

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val students = ArrayDeque(students.toList())
    val sandwiches = ArrayDeque(sandwiches.toList())
    var eaten = true

    while (eaten) {
        eaten = false
        var total = students.size
        while (total > 0) {
            total--
            val student = students.removeFirst()
            if (student == sandwiches.first()) {
                sandwiches.removeFirst()
                if (sandwiches.isEmpty()) {
                    return students.size
                }
                eaten = true
            } else {
                students.addLast(student)
            }
        }
    }
    return students.size
}