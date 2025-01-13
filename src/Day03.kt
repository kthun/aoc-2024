fun main() {
    var sum = 0L
    var calculate = true

    fun calculate(input: String): Long {
        val (a, b) = input.substringAfter("(").substringBeforeLast(")").split(",").map { it.toLong() }
        return a * b
    }

    fun execute(input: String) {
        when {
            input.startsWith("mul") -> {
                if (calculate) {
                    sum += calculate(input)
                }
            }

            input.startsWith("do()") -> {
                calculate = true
            }

            input.startsWith("don't()") -> {
                calculate = false
            }
        }
    }

    fun part1(rawInput: List<String>): Long {
        val input = rawInput.joinToString("\n")
        val regex = Regex("mul\\(\\d+,\\d+\\)")

        return regex
            .findAll(input)
            .sumOf { match ->
                calculate(match.value)
            }
    }

    fun part2(rawinput: List<String>): Long {
        val input = rawinput.joinToString("\n")
        val regex = Regex("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)")

        regex.findAll(input).forEach { execute(it.value) }

        return sum
    }

    val testInput = readInput("Day03_test")
    val testInput2 = readInput("Day03_test2")
    val input = readInput("Day03")

    check(part1(testInput) == 161L)
    check(part2(testInput2) == 48L)

    part1(input).println()
    part2(input).println()
}
