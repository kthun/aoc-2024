import kotlin.math.absoluteValue

typealias Report = List<Int>

fun main() {
    fun parseInput(input: List<String>): List<Report> = input.map { line ->
        line.split(Regex("\\s+")).map { it.toInt() }
    }

    fun Report.isValid(): Boolean {
        val direction = if (this[0] - this[1] > 0) -1 else 1
        this.zipWithNext().forEach { (a, b) ->
            if ((b - a) * direction <= 0) return false
            if ((a - b).absoluteValue !in 1..3) return false
        }
        return true
    }

    fun Report.isValidWithDampener(): Boolean {
        if (this.isValid()) return true

        return this.indices.any { i ->
            val newReport = this.toMutableList()
            newReport.removeAt(i)
            newReport.isValid()
        }
    }

    fun part1(input: List<String>): Int {
        val reports = parseInput(input)
        return reports.count { it.isValid() }
    }

    fun part2(input: List<String>): Int {
        val reports = parseInput(input)
        return reports.count { it.isValidWithDampener() }
    }

    val testInput = readInput("Day02_test")
    val input = readInput("Day02")

    check(part1(testInput) == 2)
    println(part1(input))

    check(part2(testInput) == 4)
    println(part2(input))
}
