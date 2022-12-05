import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day04/sampleInput")
        val overlappingRanges = findIfRangesAreFullyContained(lines)

        assertEquals(2, overlappingRanges)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day04/input")
        val overlappingRanges = findIfRangesAreFullyContained(lines)

        assertEquals(483, overlappingRanges)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day04/sampleInput")
        val anyOverlappingRanges = findAnyOverlappingRanges(lines)

        assertEquals(4, anyOverlappingRanges)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day04/input")
        val anyOverlappingRanges = findAnyOverlappingRanges(lines)

        assertEquals(874, anyOverlappingRanges)
    }

}