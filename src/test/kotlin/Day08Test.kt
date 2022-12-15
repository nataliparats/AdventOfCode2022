import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day08Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day08/sampleInput")!!
        val countVisibleTrees= countVisibleTrees(lines)

        assertEquals(21, countVisibleTrees)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day08/input")!!
        val countVisibleTrees= countVisibleTrees(lines)

        assertEquals(1801, countVisibleTrees)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day08/sampleInput")!!
        val countVisibleTrees= highestScenicScore(lines)

        assertEquals(8, countVisibleTrees)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day08/input")!!
        val countVisibleTrees= highestScenicScore(lines)

        assertEquals(8, countVisibleTrees)
    }

}