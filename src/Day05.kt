fun main() {
  fun List<String>.createStacks(separator: Int): MutableMap<Int, MutableList<String>> {
    val stacks = mutableMapOf<Int, MutableList<String>>()
    for (i in separator - 2 downTo 0) {
      this[i].let { line ->
        var key = 1
        line.windowed(size = 3, step = 4, partialWindows = false) { stackValue ->
          if (stackValue.isNotBlank()) {
            stacks.getOrPut(key) { mutableListOf() }.add(stackValue[1].toString())
          }
          key++
        }
      }
    }

    return stacks
  }

  fun MutableMap<Int, MutableList<String>>.buildTopString(): String =
    this.mapValues { it.value.last() }.values.joinToString("")

  fun MutableList<String>.removeLast(n: Int) {
    for (i in 1..n) {
      this.removeLast()
    }
  }

  fun part1(input: List<String>): String {
    val separator = input.indexOf("")
    val stacks = input.createStacks(separator)

    for (i in separator + 1 until input.size) {
      val split = input[i].split(" ")
      val amount = split[1].toInt()
      val from = stacks[split[3].toInt()]!!
      val to = stacks[split[5].toInt()]!!
      val stackValues = from.drop(from.size - amount)
      to.addAll(stackValues.asReversed())
      from.removeLast(amount)
    }

    return stacks.buildTopString()
  }

  fun part2(input: List<String>): String {
    val separator = input.indexOf("")
    val stacks = input.createStacks(separator)

    for (i in separator + 1 until input.size) {
      val split = input[i].split(" ")
      val amount = split[1].toInt()
      val from = stacks[split[3].toInt()]!!
      val to = stacks[split[5].toInt()]!!
      val stackValues = from.drop(from.size - amount)
      to.addAll(stackValues)
      from.removeLast(amount)
    }

    return stacks.buildTopString()
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day05_test")

  val input = readInput("Day05")
  println(part2(testInput))
  println(part2(input))
}
