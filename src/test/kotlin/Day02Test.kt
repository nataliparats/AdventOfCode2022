import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun `part1, sampleInput` () {
        val lines = readLines("day02/sampleinput")
        val score = calculateRockPaperScissorsScorePart1(lines)

        assertEquals(15, score)
    }

    @Test
    fun `part1, input` () {
        val lines = readLines("day02/input")
        val score = calculateRockPaperScissorsScorePart1(lines)

        assertEquals(11767, score)
    }

    @Test
    fun `part2, sampleInput` () {
        val lines = readLines("day02/sampleInput")
        val score = calculateRockPaperScissorsScorePart2(lines)

        assertEquals(12, score)
    }

    @Test
    fun `part2, input` () {
        val lines = readLines("day02/input")
        val score = calculateRockPaperScissorsScorePart2(lines)

        assertEquals(13886, score)
    }
}