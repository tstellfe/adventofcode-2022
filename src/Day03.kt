fun main() {
  val alphabetLow = 'a'..'z'
  val alphabetBig = 'A'..'Z'
  val alphabet = alphabetLow.toMutableList().also { it.addAll(alphabetBig.toList()) }

  fun part1(input: List<String>): Int {
    return input.sumOf { backpack ->
      val half = backpack.length / 2
      val comp1 = backpack.substring(0 until half)
      val comp2 = backpack.substring(half until backpack.length).toCharArray().joinToString(separator = "|")

      val result = comp2.toRegex().find(comp1)?.value ?: throw Exception(backpack)
      alphabet.indexOf(result[0]) + 1
    }
  }

  fun part2(input: List<String>): Int {
    return input.windowed(3, 3) { group ->
      val regex1 = group[0].toCharArray().joinToString(separator = "|").toRegex()
      val regex2 = regex1.findAll(group[1]).map { it.value }.joinToString(separator = "|").toRegex()

      val result2 = regex2.find(group[2])?.value ?: throw Exception(group.toString())
      alphabet.indexOf(result2[0]) + 1
    }.sum()
  }

  val testInput = readInput("Day03_test")

  val input = readInput("Day03")
  println(part2(testInput))
  println(part2(input))

}
