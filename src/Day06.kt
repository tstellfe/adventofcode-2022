fun main() {
  fun String.findBuffer(window: Int): Int {
    for (i in 0..this.length step 1) {
      if (this.slice(i until i + window).toSet().size == window) {
        return i + window
      }
    }
    return 0
  }


  fun part1(input: List<String>): Int {
    return input.map { line ->
      line.findBuffer(4)
    }.first()
  }

  fun part2(input: List<String>): Int {
    return input.map { line ->
      line.findBuffer(14)
    }.first()
  }

// test if implementation meets criteria from the description, like:
  val testInput = readInput("Day06_test")

  val input = readInput("Day06")
  println(part2(testInput))
  println(part2(input))
}
