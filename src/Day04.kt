fun main() {
    fun part1(input: List<String>): Int {
        var xmasCount = 0

        for (i in input.indices) {
            for (j in input[i].indices) {
                // Horizontal
                if (input[i][j] == 'X' && input[i].getOrNull(j + 1) == 'M' && input[i].getOrNull(j + 2) == 'A' && input[i].getOrNull(
                        j + 3
                    ) == 'S'
                ) {
                    xmasCount++
                }
                // Horizontal backwards
                if (input[i][j] == 'X' && input[i].getOrNull(j - 1) == 'M' && input[i].getOrNull(j - 2) == 'A' && input[i].getOrNull(
                        j - 3
                    ) == 'S'
                ) {
                    xmasCount++
                }
                // Vertical
                if (input[i][j] == 'X' && input.getOrNull(i + 1)?.getOrNull(j) == 'M' && input.getOrNull(i + 2)
                        ?.getOrNull(j) == 'A' && input.getOrNull(i + 3)?.getOrNull(j) == 'S'
                ) {
                    xmasCount++
                }
                // Vertical backwards
                if (input[i][j] == 'X' && input.getOrNull(i - 1)?.getOrNull(j) == 'M' && input.getOrNull(i - 2)
                        ?.getOrNull(j) == 'A' && input.getOrNull(i - 3)?.getOrNull(j) == 'S'
                ) {
                    xmasCount++
                }
                // Diagonal down right
                if (input[i][j] == 'X' && input.getOrNull(i + 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i + 2)
                        ?.getOrNull(j + 2) == 'A' && input.getOrNull(i + 3)?.getOrNull(j + 3) == 'S'
                ) {
                    xmasCount++
                }
                // Diagonal down left
                if (input[i][j] == 'X' && input.getOrNull(i + 1)?.getOrNull(j - 1) == 'M' && input.getOrNull(i + 2)
                        ?.getOrNull(j - 2) == 'A' && input.getOrNull(i + 3)?.getOrNull(j - 3) == 'S'
                ) {
                    xmasCount++
                }
                // Diagonal up right
                if (input[i][j] == 'X' && input.getOrNull(i - 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i - 2)
                        ?.getOrNull(j + 2) == 'A' && input.getOrNull(i - 3)?.getOrNull(j + 3) == 'S'
                ) {
                    xmasCount++
                }
                // Diagonal up left
                if (input[i][j] == 'X' && input.getOrNull(i - 1)?.getOrNull(j - 1) == 'M' && input.getOrNull(i - 2)
                        ?.getOrNull(j - 2) == 'A' && input.getOrNull(i - 3)?.getOrNull(j - 3) == 'S'
                ) {
                    xmasCount++
                }
            }
        }
        return xmasCount
    }

    fun part2(input: List<String>): Int {
        var xmasCount = 0

        for (i in input.indices) {
            for (j in input[i].indices) {
                if (input[i][j] == 'A') {
                    // First MAS down right
                    if (input.getOrNull(i - 1)?.getOrNull(j - 1) == 'M' && input.getOrNull(i + 1)?.getOrNull(j + 1) == 'S') {
                        // Second MAS down left
                        if (input.getOrNull(i - 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i + 1)?.getOrNull(j - 1) == 'S') {
                            xmasCount++
                        }
                        // Second MAS up right
                        if (input.getOrNull(i + 1)?.getOrNull(j - 1) == 'M' && input.getOrNull(i - 1)?.getOrNull(j + 1) == 'S') {
                            xmasCount++
                        }
                    }
                    // First MAS down left
                    if (input.getOrNull(i - 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i + 1)?.getOrNull(j - 1) == 'S') {
                        // Second MAS up left
                        if (input.getOrNull(i + 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i - 1)?.getOrNull(j - 1) == 'S') {
                            xmasCount++
                        }
                    }
                    // First MAS up right
                    if (input.getOrNull(i + 1)?.getOrNull(j - 1) == 'M' && input.getOrNull(i - 1)?.getOrNull(j + 1) == 'S') {
                        // Second MAS up left
                        if (input.getOrNull(i + 1)?.getOrNull(j + 1) == 'M' && input.getOrNull(i - 1)?.getOrNull(j - 1) == 'S') {
                            xmasCount++
                        }
                    }
                }
            }
        }
        return xmasCount
    }

    val testInput = readInput("Day04_test")
    val input = readInput("Day04")

    part1(testInput).println()
    part1(input).println()

    part2(testInput).println()
    part2(input).println()
}
