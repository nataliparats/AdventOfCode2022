fun calculateSumOfPriorities(lines: List<String>): Int =
    lines.sumOf { line ->
        val (rucksackCompartment1: Set<Char>, rucksackCompartment2: Set<Char>) =
            line.chunked(line.length / 2)
                .map { it.toSet() }

        val sharedItem = rucksackCompartment1.intersect(rucksackCompartment2).first()
        sharedItem.mapPriorities()
    }

fun calculateBadgeSumOfPriorities(lines: List<String>): Int =
    lines.chunked(3).sumOf { group ->
        val (rucksack1, rucksack2, rucksack3) = group.map { it.toSet() }
        val sharedItem = (rucksack1 intersect rucksack2 intersect rucksack3).first()

        sharedItem.mapPriorities()
    }

private fun Char.mapPriorities() = if (isLowerCase())
    this - 'a' + 1
else
    this - 'A' + 27