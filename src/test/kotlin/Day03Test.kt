import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day03/sampleInput")
        val prioritySum = calculateSumOfPriorities(lines)

        assertEquals(157, prioritySum)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day03/input")
        val prioritySum = calculateSumOfPriorities(lines)

        assertEquals(8298, prioritySum)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day03/sampleInput")
        val prioritySum = calculateBadgeSumOfPriorities(lines)

        assertEquals(70, prioritySum)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day03/input")
        val prioritySum = calculateBadgeSumOfPriorities(lines)

        assertEquals(2708, prioritySum)
    }

}