fun main() {
  fun List<String>.toSummedList(): MutableList<Int> {
    val summed: MutableList<Int> = mutableListOf()
    var temp = 0
    this.forEach {
      if (it != "") temp += it.toInt()
      else {
        summed.add(temp)
        temp = 0
      }
    }
    summed.add(temp)
    return summed
  }

  fun part1(input: List<String>): Int {
    return input.toSummedList().max()
  }

  fun part2(input: List<String>): Int {
    val mutableSummed = input.toSummedList().also { it.sortDescending() }
    return mutableSummed[0] + mutableSummed[1] + mutableSummed[2]
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")

  val input = readInput("Day01")
  println(part2(testInput))
  println(part2(input))
}
