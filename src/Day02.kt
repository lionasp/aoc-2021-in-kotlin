fun main() {


    fun parseCommands(input: List<String>): List<Pair<String, Int>> {
        val result = mutableListOf<Pair<String, Int>>()
        for (i in input) {
            val split = i.split(" ")
            result.add(Pair(split[0], split[1].toInt()))
        }
        return result
    }

    fun part1(input: List<Pair<String, Int>>): Int {
        var horizontal = 0
        var vertical = 0
        for (i in input) {
            when (i.first) {
                "forward" -> horizontal += i.second
                "down" -> vertical += i.second
                "up" -> vertical -= i.second
            }
        }
        return horizontal * vertical
    }

    fun part2(input: List<Pair<String, Int>>): Int {
        var horizontal = 0
        var vertical = 0
        var aim = 0
        for (i in input) {
            when (i.first) {
                "forward" -> {
                    horizontal += i.second
                    vertical += aim * i.second
                }
                "down" -> aim += i.second
                "up" -> aim -= i.second
            }
        }
        return horizontal * vertical

    }

    val testInput = readInput("Day02_test")
    val parsedTestInput = parseCommands(testInput)

    check(part1(parsedTestInput) == 150)
    check(part2(parsedTestInput) == 900)

    val input = readInput("Day02")
    val parsedInput = parseCommands(input)
    println(part1(parsedInput))
    println(part2(parsedInput))
}
