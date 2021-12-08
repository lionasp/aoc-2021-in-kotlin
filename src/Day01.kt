fun main() {
    fun part1(input: List<Int>): Int {
        var result = 0
        for (i in input.indices) {
            if (i == 0) {
                continue
            }
            if (input[i] > input[i-1]) {
                result++
            }
        }
        return result
    }

    fun part2(input: List<Int>): Int {
        var result = 0
        for (i in input.indices) {
            if (i + 3 >= input.size) {
                break
            }
            if (input[i + 3] > input[i]) {
                result++
            }
        }
        return result

    }

    val testInput = readInput("Day01_test")
    val parsedTestInput = testInput.map { it.toInt() }
    check(part1(parsedTestInput) == 7)
    check(part2(parsedTestInput) == 5)

    val input = readInput("Day01")
    val parsedInput = input.map { it.toInt() }
    println(part1(parsedInput))
    println(part2(parsedInput))
}
