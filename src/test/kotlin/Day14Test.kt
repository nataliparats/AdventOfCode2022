import Day14.Companion.createPath
import Day14.Companion.createPaths
import Day14.Companion.parseInput
import Day14.GridPart1
import Day14.GridPart2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day14Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day14/sampleInput")!!
        val path = createPaths(lines)
        val grid = GridPart1(path)
        val result = grid.keepPouring()
        val expected = 24

        assertEquals(expected, result)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day14/input")!!
        val path = createPaths(lines)
        val grid = GridPart1(path)
        val result = grid.keepPouring()
        val expected = 728

        assertEquals(expected, result)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day14/sampleInput")!!
        val path = createPaths(lines)
        val grid = GridPart2(path)

        val result = grid.keepPouring()
        val expected = 93

        assertEquals(expected, result)
    }


    @Test
    fun `part2, input`() {
        val lines = readLines("day14/input")!!
        val path = createPaths(lines)
        val grid = GridPart2(path)

        val result = grid.keepPouring()
        val expected = 27623

        assertEquals(expected, result)
    }
}