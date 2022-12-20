fun main() {
  fun part1(input: List<String>): Int {
    return input.sumOf {
      val opponent = it.split(" ")[0]
      val mine = it.split(" ")[1]
      RockPaperScissor.from(opponent)!!.score(mine)
    }
  }

  fun part2(input: List<String>): Int {
    return input.sumOf {
      val opponent = it.split(" ")[0]
      val mine = it.split(" ")[1]
      RockPaperScissor.from(opponent)!!.roundResult(mine)
    }
  }

  val testInput = readInput("Day02_test")

  val input = readInput("Day02")
  println(part2(testInput))
  println(part2(input))

}

enum class RockPaperScissor(val input: String) {
  ROCK("A") {
    override fun score(input: String): Int = when (input) {
      "X" -> 1 + 3
      "Y" -> 2 + 6
      "Z" -> 3 + 0
      else -> throw Exception()
    }

    override fun roundResult(input: String): Int = when (input) {
      "X" -> score("Z")
      "Y" -> score("X")
      "Z" -> score("Y")
      else -> throw Exception()
    }
  },
  PAPER("B") {
    override fun score(input: String): Int = when (input) {
      "X" -> 1 + 0
      "Y" -> 2 + 3
      "Z" -> 3 + 6
      else -> throw Exception()
    }

    override fun roundResult(input: String): Int = when (input) {
      "X" -> score("X")
      "Y" -> score("Y")
      "Z" -> score("Z")
      else -> throw Exception()
    }
  },
  SCISSOR("C") {
    override fun score(input: String): Int = when (input) {
      "X" -> 1 + 6
      "Y" -> 2 + 0
      "Z" -> 3 + 3
      else -> throw Exception()
    }

    override fun roundResult(input: String): Int = when (input) {
      "X" -> score("Y")
      "Y" -> score("Z")
      "Z" -> score("X")
      else -> throw Exception()
    }
  };

  abstract fun score(input: String): Int
  abstract fun roundResult(input: String): Int

  companion object {
    fun from(input: String): RockPaperScissor? = values().firstOrNull { it.input == input }
  }
}
