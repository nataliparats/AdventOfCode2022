/**
 *  2-4,6-8
    2-3,4-5
    5-7,7-9
    2-8,3-7
    6-6,4-6
    2-6,4-8
 */
fun findIfRangesAreFullyContained(lines: List<String>): Int {
    return lines.map(::parseLineOfElfRanges).count(::areRangesFullyContained)
}

fun findAnyOverlappingRanges(lines: List<String>): Int {
    return lines.map (::parseLineOfElfRanges).count(::doRangesOverlap)
}

private fun parseLineOfElfRanges(line: String): Pair<IntRange, IntRange> {
    val (elf1Range, elf2Range) = line.split(',').map { range: String ->
            val (begin, end) = range.split('-').map { it.toInt() }
                begin..end
            }
    return elf1Range to elf2Range
}

private fun areRangesFullyContained(pairOfElfRanges: Pair<IntRange, IntRange>): Boolean {
    return pairOfElfRanges.first.containsAll(pairOfElfRanges.second)
}

private fun doRangesOverlap(pairOfElfRanges: Pair<IntRange, IntRange>): Boolean {
    return pairOfElfRanges.first.containsAny(pairOfElfRanges.second)
}

private fun IntRange.containsAny(elfPairRange2: IntRange) =
    this.any { elfPairRange2.contains(it) } || elfPairRange2.any { this.contains(it) }

private fun IntRange.containsAll(elfPairRange2: IntRange) =
    this.all { elfPairRange2.contains(it) } || elfPairRange2.all { this.contains(it) }
