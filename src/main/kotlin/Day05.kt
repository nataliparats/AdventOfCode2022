fun findTopCratesPart1(lines: String): String {

    val (crateStacks, rearrangementProcedure) = lines.split("\n\n")

    val exampleCrateStacks = crateStacks.parseCrateStacks()

    rearrangementProcedure.parseInstructions().forEach { (amount, from, to) ->
        exampleCrateStacks.executeRearrangePart1(from, to, amount)
    }

    return exampleCrateStacks.values.joinToString(separator = "") { "${it.last()}" }

}

fun findTopCratesPart2(lines: String): String {

    val (crateStacks, rearrangementProcedure) = lines.split("\n\n")

    val exampleCrateStacks = crateStacks.parseCrateStacks()

    rearrangementProcedure.parseInstructions().forEach { (amount, from, to) ->
        exampleCrateStacks.executeRearrangePart2(from, to, amount)
    }

    return exampleCrateStacks.values.joinToString(separator = "") { "${it.last()}" }

}

data class Instruction(
    val amount: Int,
    val from: Int,
    val to: Int
)

private fun String.parseInstructions(): List<Instruction> =
    this.lines().map { line ->
        val splitElements = line.split(" ")
        Instruction(
            splitElements[1].toInt(),
            splitElements[3].toInt(),
            splitElements[5].toInt()
        )
    }

private fun String.parseCrateStacks(): Map<Int, MutableList<Char>> {
    val lines = this.lines()
        .map { line -> line.chunked(4).map { chunk -> chunk[1] } }
        .reversed()
    val keys = lines[0].map { it.toString().toInt() }

    return keys.mapIndexed { i: Int, key: Int ->
        val stack = lines.mapNotNull { line ->
            val result: Char? = line.getOrNull(i)
            if (result == ' ')
                null
            else
                result
        }
        key to stack.toMutableList()
    }.toMap()
}

private fun Map<Int, MutableList<Char>>.executeRearrangePart1(
    from: Int,
    to: Int,
    amount: Int
) {
    val fromStack = this[from]!!
    val toStack = this[to]!!
    val itemsToAdd = fromStack.takeLastAndDrop(amount).reversed()
    toStack.addAll(itemsToAdd)
}

private fun Map<Int, MutableList<Char>>.executeRearrangePart2(
    from: Int,
    to: Int,
    amount: Int
) {
    val fromStack = this[from]!!
    val toStack = this[to]!!
    val itemsToAdd = fromStack.takeLastAndDrop(amount)
    toStack.addAll(itemsToAdd)
}



private fun <E> MutableList<E>.takeLastAndDrop(amount: Int): List<E> {
    val draw = this.takeLast(amount)
    repeat(amount) { this.removeLast() }

    return draw
}
