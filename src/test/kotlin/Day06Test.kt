import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Test {

    @Test
    fun `part1, sample input 1`() {
        val datastream = readText("day06/sampleInput1")!!

        //The first position where the four most recently received characters were all different.
        val requiredPosition = findRequiredPosition(datastream, 4)

        assertEquals(7, requiredPosition)
    }

    @Test
    fun `part1, sample input 2`() {
        val datastream = readText("day06/sampleInput2")!!

        val requiredPosition = findRequiredPosition(datastream, 4)

        assertEquals(5, requiredPosition)
    }

    @Test
    fun `part1, input`() {
        val datastream = readText("day06/input")!!

        val requiredPosition = findRequiredPosition(datastream, 4)

        assertEquals(1282, requiredPosition)
    }

    @Test
    fun `part2, sample input 1`() {
        val datastream = readText("day06/sampleInput1")!!

        val requiredPosition = findRequiredPosition(datastream, 14)

        assertEquals(19, requiredPosition)
    }

    @Test
    fun `part2, sample input 2`() {
        val datastream = readText("day06/sampleInput2")!!

        val requiredPosition = findRequiredPosition(datastream, 14)

        assertEquals(23, requiredPosition)
    }

    @Test
    fun `part2, input`() {
        val datastream = readText("day06/input")!!

        val requiredPosition = findRequiredPosition(datastream, 14)

        assertEquals(1282, requiredPosition)
    }

}