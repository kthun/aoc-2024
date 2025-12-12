import kotlin.system.exitProcess

fun main() {

    class GuardState(var pos: Pair<Int, Int>, var direction: Pair<Int, Int>)

    val charToDirection = mapOf(
        '^' to Pair(0, -1),
        '>' to Pair(1, 0),
        'v' to Pair(0, 1),
        '<' to Pair(-1, 0)
    )

    fun GuardState.turnRight() {
        direction = when (direction) {
            Pair(0, -1) -> Pair(1, 0)
            Pair(1, 0) -> Pair(0, 1)
            Pair(0, 1) -> Pair(-1, 0)
            Pair(-1, 0) -> Pair(0, -1)
            else -> throw IllegalArgumentException("Invalid direction")
        }
    }

    fun printCurrentState(map: List<String>, state: GuardState) {
        map.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                print(
                    if (x == state.pos.first && y == state.pos.second) {
                        when (state.direction) {
                            Pair(0, -1) -> '^'
                            Pair(1, 0) -> '>'
                            Pair(0, 1) -> 'v'
                            Pair(-1, 0) -> '<'
                            else -> throw IllegalArgumentException("Invalid direction")
                        }
                } else {
                    c
                }
                )
            }
            println()
        }
    }

    fun GuardState.move(map: List<String>): Boolean {
        val newPos = Pair(pos.first + direction.first, pos.second + direction.second)
        if (newPos.first !in map[0].indices || newPos.second !in map.indices) {
            return false
        }
        if (map[newPos.second][newPos.first] != '.') {
            this.turnRight()
            this.move(map)
        } else {
            pos = newPos
        }
        return true
    }

    fun part1(input: List<String>): Int {

        val height = input.size
        val width = input[0].length
        val visited = Array(width) { BooleanArray(height) { false } }

        val startState = input.mapIndexed { y, row ->
            val mapIndexed = row.mapIndexed { x, c ->
                if (c in "^v<>") {
                    GuardState(Pair(x, y), charToDirection[c]!!)
                } else {
                    null
                }
            }
            mapIndexed
        }.flatten().filterNotNull().first()

        val map = input.toMutableList()
        map[startState.pos.second] = map[startState.pos.second].replaceRange(startState.pos.first, startState.pos.first + 1, ".")

        val state = startState
        var lastMoveSuccess = true

        do {
//            printCurrentState(map, state!!)
//            println()
            visited[state.pos.second][state.pos.first] = true
            lastMoveSuccess = state.move(map)
        } while (lastMoveSuccess)

        return visited.flatMap { it.toList() }.count { it }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day06_test")
    val input = readInput("Day06")

    part1(testInput).println()
    check(part1(testInput) == 41)
//    check(part2(testInput) == 123)

    part1(input).println()
//    part2(input).println()
}
