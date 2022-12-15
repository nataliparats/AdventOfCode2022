import Day10.Companion.calculateOutput
import Day10.Companion.calculateSignalStrength
import Day10.Companion.calculateSingalStrengthPerCycleNumber
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day10Test {

    @Test
    fun `part1, sample input in 20 cycles`() {
        val lines = readLines("day10/sampleInput")!!
        val signalStrengthIn40Cycles= calculateSingalStrengthPerCycleNumber(lines, 20)

        assertEquals(420, signalStrengthIn40Cycles)
    }

    @Test
    fun `part1, sample input in 60 cycles`() {
        val lines = readLines("day10/sampleInput")!!
        val signalStrengthIn40Cycles= calculateSingalStrengthPerCycleNumber(lines, 60)

        assertEquals(1140, signalStrengthIn40Cycles)
    }

    @Test
    fun `part1, sample input Total`() {
        val lines = readLines("day10/sampleInput")!!
        val signalStrength= calculateSignalStrength(lines)

        assertEquals(13140, signalStrength)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day10/sampleInput")!!
        val signalStrength= calculateOutput(lines)

        val expectedResult = """
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######.....
        """.trimIndent()

        assertEquals(expectedResult, signalStrength)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day10/input")!!
        val signalStrength= calculateOutput(lines)

        val expectedResult = """
            ###..####.###...##..####.####...##.###..
            #..#....#.#..#.#..#....#.#.......#.#..#.
            #..#...#..###..#......#..###.....#.###..
            ###...#...#..#.#.##..#...#.......#.#..#.
            #....#....#..#.#..#.#....#....#..#.#..#.
            #....####.###...###.####.####..##..###..
        """.trimIndent()

        assertEquals(expectedResult, signalStrength)
    }

}