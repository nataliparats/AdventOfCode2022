import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Test {

    @Test
    fun `part1, sample input`() {
        val lines = readText("day05/sampleInput")!!
        val topCrates = findTopCratesPart1(lines)

        assertEquals("CMZ", topCrates)
    }

    @Test
    fun `part1, input`() {
        val lines = readText("day05/input")!!
        val topCrates = findTopCratesPart1(lines)

        assertEquals("WHTLRMZRC", topCrates)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readText("day05/sampleInput")!!
        val topCrates = findTopCratesPart2(lines)

        assertEquals("MCD", topCrates)
    }

    @Test
    fun `part2, input`() {
        val lines = readText("day05/input")!!
        val topCrates = findTopCratesPart2(lines)

        assertEquals("GMPMLWNMG", topCrates)
    }

}