import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class Day01Test {

    @Test
    fun `part1, sampleInput` () {
        val lines = readLines("day01/sampleInput")
        val mostCalories = calculateMostCalories(lines)

        assertEquals( 24000, mostCalories)
    }

    @Test
    fun `part1, input1` () {
        val lines = readLines("day01/input")
        val mostCalories = calculateMostCalories(lines)

        assertEquals(70296, mostCalories)
    }

    @Test
    fun `part2, sampleInput` () {
        val lines = readLines("day01/sampleInput")
        val top3Calories = calculateTop3Calories(lines)

        assertEquals(45000, top3Calories)
    }

    @Test
    fun `part2, input1` () {
        val lines = readLines("day01/input")
        val top3Calories = calculateTop3Calories(lines)

        assertEquals(205381, top3Calories)
    }
}