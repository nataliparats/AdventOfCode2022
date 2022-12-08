import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day07Test {

    @Test
    fun `part1, sample input`() {
        val lines = readLines("day07/sampleInput")!!
        val totalSizeOfDir= totalSizeOfDirWithLessThan100000Size(lines)

        assertEquals(95437, totalSizeOfDir)
    }

    @Test
    fun `part1, input`() {
        val lines = readLines("day07/input")!!
        val totalSizeOfDir= totalSizeOfDirWithLessThan100000Size(lines)

        assertEquals(1182909, totalSizeOfDir)
    }

    @Test
    fun `part2, sample input`() {
        val lines = readLines("day07/sampleInput")!!
        val size = findSizeOfDirectoryToDelete(lines)

        assertEquals(24933642, size)
    }

    @Test
    fun `part2, input`() {
        val lines = readLines("day07/input")!!
        val size = findSizeOfDirectoryToDelete(lines)

        assertEquals(2832508, size)
    }

}