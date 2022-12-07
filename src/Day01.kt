fun main() {
  fun part1(input: List<String>): Int {
    val summed: MutableList<Int> = mutableListOf()
    var temp = 0
    input.forEach {
      if (it != "") temp += it.toInt()
      else {
        summed.add(temp)
        temp = 0
      }
    }

    return summed.max()
  }

  fun part2(input: List<String>): Int {
    return input.size
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")

  val input = readInput("Day01")
  println(part1(testInput))
  println(part1(input))
}
