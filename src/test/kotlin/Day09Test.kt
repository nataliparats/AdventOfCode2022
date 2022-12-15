import Day09.Companion.day09part1
import Day09.Companion.day09part2
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day09Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day09/sampleInput")!!
        val result= day09part1(lines)

        assertEquals(13, result)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day09/input")!!
        val result= day09part1(lines)

        assertEquals(5735, result)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day09/sampleInput2")!!
        val result= day09part2(lines)

        assertEquals(36, result)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day09/input")!!
        val result= day09part2(lines)

        assertEquals(2478, result)
    }

}