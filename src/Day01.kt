import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (listA, listB) = parseInput(input)

        return listA.sorted().zip(listB.sorted()).sumOf { (a, b) ->
            abs(a - b)
        }
    }

    fun part2(input: List<String>): Int {
        val (listA, listB) = parseInput(input)

        val frequencies = listB.groupingBy { it }.eachCount()

        return listA.sumOf { a ->
            a * frequencies.getOrDefault(a, 0)
        }
    }

    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    check(part1(testInput) == 11)
    part1(input).println()

    check(part2(testInput) == 31)
    part2(input).println()
}

fun parseInput(input: List<String>) = input.map { line ->
    val first = line.substringBefore(" ").toInt()
    val second = line.substringAfterLast(" ").toInt()
    first to second
}.unzip()
