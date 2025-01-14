fun main() {

    fun part1(input: List<String>): Int {
        val rules = input.takeWhile(String::isNotBlank).map { line ->
            line.split("|")
                .let { it[0].toInt() to it[1].toInt() }
        }

        val updates = input.dropWhile { it.isNotBlank() }.drop(1).map { line ->
            line.split(",").map { it.toInt() }
        }

        val comparator = Comparator { a: Int, b: Int ->
            when {
                Pair(a, b) in rules -> -1
                Pair(b, a) in rules -> 1
                else -> 0
            }
        }

        val correctUpdates = updates.filter { update ->
            update.sortedWith(comparator) == update
        }
        return correctUpdates.sumOf { update -> update[update.size / 2] }
    }

    fun part2(input: List<String>): Int {
        val rules = input.takeWhile(String::isNotBlank).map { line ->
            line.split("|")
                .let { it[0].toInt() to it[1].toInt() }
        }

        val updates = input.dropWhile { it.isNotBlank() }.drop(1).map { line ->
            line.split(",").map { it.toInt() }
        }

        val comparator = Comparator { a: Int, b: Int ->
            when {
                Pair(a, b) in rules -> -1
                Pair(b, a) in rules -> 1
                else -> 0
            }
        }

        val incorrectUpdates = updates.filterNot { update ->
            update.sortedWith(comparator) == update
        }

        val correctedUpdates = incorrectUpdates.map { update -> update.sortedWith(comparator) }

        return correctedUpdates.sumOf { update -> update[update.size / 2] }
    }

    val testInput = readInput("Day05_test")
    val input = readInput("Day05")

    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    part1(input).println()
    part2(input).println()
}
