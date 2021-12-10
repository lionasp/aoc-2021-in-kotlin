fun main() {
    fun part1(input: List<String>): Int {
        val binaryLength = input.first().length
        val gamma = StringBuilder()
        val epsilon = StringBuilder()

        for (i in 0 until binaryLength) {
            var zeros = 0
            var ones = 0
            for (binary in input) {
                if (binary[i].toString() == "1") {
                    ones++
                } else {
                    zeros++
                }
            }
            gamma.append(if (ones > zeros) "1" else "0")
            epsilon.append(if (ones < zeros) "1" else "0")

        }

        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2)
    }


    fun scan(report: List<String>, index: Int, comp: (Int, Int) -> Boolean): Int {
        if (report.size == 1) {
            return Integer.parseInt(report.first(), 2)
        }
        val binaryLength = report.first().length
        val nextIndex = (index + 1) % (binaryLength + 1)

        val ones = report.filter { it[index].toString() == "1" }
        val zeroes = report.filter { it[index].toString() == "0" }
        return if (comp(ones.size, zeroes.size)) scan(ones, nextIndex, comp) else scan(zeroes, nextIndex, comp)
    }

    fun oxygenComparator(first: Int, second: Int): Boolean = first >= second
    fun co2Comparator(first: Int, second: Int): Boolean = second >= first

    fun part2(input: List<String>): Int {
        val oxygen = scan(input, 0, ::oxygenComparator)
        val co2 = scan(input, 0, ::co2Comparator)
        println(oxygen)
        println(co2)
        return input.size

    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")

    println(part1(input))
    println(part2(input))
}
