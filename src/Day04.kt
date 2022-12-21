fun main() {
  fun String.toSections() = this.split(",").map { pair ->
    val sections = pair.split("-")
    sections[0].toInt()..sections[1].toInt()
  }

  fun IntRange.isIn(other: IntRange): Boolean {
    this.forEach {
      if (!other.contains(it)) return false
    }
    return true
  }

  fun IntRange.hasAtLeastOne(other: IntRange): Boolean {
    this.forEach {
      if (other.contains(it)) return true
    }
    return false
  }

  fun part1(input: List<String>): Int {
    return input.sumOf { line ->
      val sections = line.toSections()

      val a = sections[0].isIn(sections[1])
      val b = sections[1].isIn(sections[0])

      if(a or b) 1 as Int else 0 as Int
    }
  }

  fun part2(input: List<String>): Int {
    return input.sumOf { line ->
      val sections = line.toSections()

      val a = sections[0].hasAtLeastOne(sections[1])
      val b = sections[1].hasAtLeastOne(sections[0])

      if(a or b) 1 as Int else 0 as Int
    }
  }

  val testInput = readInput("Day04_test")

  val input = readInput("Day04")
  println(part2(testInput))
  println(part2(input))

}
