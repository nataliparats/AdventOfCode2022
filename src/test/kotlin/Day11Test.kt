import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11Test {

    private val testMonkeys = createTestMonkeys()
    @Test
    fun `part1, sample input, test Monkey turn`() {
        val testMonkey0 = testMonkeys[0]
        val itemsThrownTo = testMonkey0.turn()

        val expected = listOf(
            Pair(Item(500), MonkeyId(3)),
            Pair(Item(620), MonkeyId(3)))

        assertEquals(expected, itemsThrownTo)
    }

    @Test
    fun `part1, play 1 round`() {
        KeepAway(testMonkeys).doRounds(1)

        val listOfItemsAfterOneRound = testMonkeys.map { it.items.map { it.worryValue } }
        val expected = listOf<List<Long>>(
            listOf(20, 23, 27, 26),
            listOf(2080, 25, 167, 207, 401, 1046),
            listOf(),
            listOf(),
        )

        assertEquals(expected, listOfItemsAfterOneRound)
    }

    @Test
    fun `part1, play 20 round`() {
        KeepAway(testMonkeys).doRounds(20)

        val listOfItemsAfterOneRound = testMonkeys.map { it.items.map { it.worryValue } }
        val expected = listOf<List<Long>>(
            listOf(10, 12, 14, 26, 34),
            listOf(245, 93, 53, 199, 115),
            listOf(),
            listOf(),
        )

        assertEquals(expected, listOfItemsAfterOneRound)
    }
    @Test
    fun `part1, sample input`() {
        val levelOfMonkeyBusiness = levelOfMonkeyBusiness(testMonkeys, 20)

        assertEquals(Item(10605), levelOfMonkeyBusiness)
    }

    @Test
    fun `part1, input`() {
        val monkeys: List<Monkey> = createPart1InputMonkeys()
        val levelOfMonkeyBusiness = levelOfMonkeyBusiness(monkeys, 20)

        assertEquals(Item(88208), levelOfMonkeyBusiness)
    }

    @Test
    fun `part2, sample input`() {
        val levelOfMonkeyBusiness = levelOfMonkeyBusiness(createTestMonkeysPart2(), 10000)

        assertEquals(Item(2713310158), levelOfMonkeyBusiness)
    }

    @Test
    fun `part2, input`() {
        val levelOfMonkeyBusiness = levelOfMonkeyBusiness(createPart2InputMonkeys(), 10000)

        assertEquals(Item(88208), levelOfMonkeyBusiness)
    }

    private fun createTestMonkeys() =
        listOf(
            Monkey(
                mutableListOf(Item(79), Item(98)),
                { Item(it.worryValue * 19)},
                Test(23, MonkeyId(2), MonkeyId(3))
            ),
            Monkey(
                mutableListOf(Item(54), Item(65), Item(75), Item(74)),
                { Item(it.worryValue + 6) },
                Test(19, MonkeyId(2), MonkeyId(0))
            ),
            Monkey(
                mutableListOf(Item(79), Item(60), Item(97)),
                { Item(it.worryValue * it.worryValue) },
                Test(13, MonkeyId(1), MonkeyId(3))
            ),
            Monkey(
                mutableListOf(Item(74)),
                { Item(it.worryValue + 3)},
                Test(17, MonkeyId(0), MonkeyId(1))
            ),
        )

    private fun createPart1InputMonkeys() =
        listOf(
            Monkey(
                mutableListOf(Item(71), Item(86)),
                { Item(it.worryValue * 13) },
                Test(19, MonkeyId(6), MonkeyId(7))
            ),
            Monkey(
                mutableListOf(Item(66), Item(50), Item(90), Item(53), Item(88), Item(85)),
                { Item(it.worryValue + 3) },
                Test(2, MonkeyId(5), MonkeyId(4))
            ),
            Monkey(
                mutableListOf(Item(97), Item(54), Item(89), Item(62), Item(84), Item(80), Item(63)),
                { Item(it.worryValue + 6) },
                Test(13, MonkeyId(4), MonkeyId(1))
            ),
            Monkey(
                mutableListOf(Item(82), Item(97), Item(56), Item(74)),
                { Item(it.worryValue + 2) },
                Test(5, MonkeyId(6), MonkeyId(0))
            ),
            Monkey(
                mutableListOf(Item(50), Item(99), Item(67), Item(61), Item(86)),
                { Item(it.worryValue * it.worryValue) },
                Test(7, MonkeyId(5), MonkeyId(3))
            ),
            Monkey(
                mutableListOf(Item(61), Item(66), Item(72), Item(55), Item(64), Item(53), Item(72), Item(63)),
                { Item(it.worryValue + 4) },
                Test(11, MonkeyId(3), MonkeyId(0))
            ),
            Monkey(
                mutableListOf(Item(59), Item(79), Item(63)),
                { Item(it.worryValue * 7) },
                Test(17, MonkeyId(2), MonkeyId(7))
            ),
            Monkey(
                mutableListOf(Item(55)),
                { Item(it.worryValue + 7) },
                Test(3, MonkeyId(2), MonkeyId(1))
            ),
        )

    private val divisorTestMonkeys = 23 * 19 * 13 * 17
    private fun createTestMonkeysPart2() =
        listOf(
            Monkey(
                mutableListOf(Item(79), Item(98)),
                { Item(it.worryValue * 19)},
                Test(23, MonkeyId(2), MonkeyId(3)),
                {Item (it.worryValue % divisorTestMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(54), Item(65), Item(75), Item(74)),
                { Item(it.worryValue + 6) },
                Test(19, MonkeyId(2), MonkeyId(0)),
                {Item (it.worryValue % divisorTestMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(79), Item(60), Item(97)),
                { Item(it.worryValue * it.worryValue) },
                Test(13, MonkeyId(1), MonkeyId(3)),
                {Item (it.worryValue % divisorTestMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(74)),
                { Item(it.worryValue + 3)},
                Test(17, MonkeyId(0), MonkeyId(1)),
                {Item (it.worryValue % divisorTestMonkeys)}
            ),
        )

    private val divisorInputMonkeys = 19 * 2 * 13 * 5 * 7 * 11 * 17 * 3
    private fun createPart2InputMonkeys() =
        listOf(
            Monkey(
                mutableListOf(Item(71), Item(86)),
                { Item(it.worryValue * 13) },
                Test(19, MonkeyId(6), MonkeyId(7)),
                {Item (it.worryValue % divisorInputMonkeys)}

            ),
            Monkey(
                mutableListOf(Item(66), Item(50), Item(90), Item(53), Item(88), Item(85)),
                { Item(it.worryValue + 3) },
                Test(2, MonkeyId(5), MonkeyId(4)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(97), Item(54), Item(89), Item(62), Item(84), Item(80), Item(63)),
                { Item(it.worryValue + 6) },
                Test(13, MonkeyId(4), MonkeyId(1)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(82), Item(97), Item(56), Item(74)),
                { Item(it.worryValue + 2) },
                Test(5, MonkeyId(6), MonkeyId(0)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(50), Item(99), Item(67), Item(61), Item(86)),
                { Item(it.worryValue * it.worryValue) },
                Test(7, MonkeyId(5), MonkeyId(3)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(61), Item(66), Item(72), Item(55), Item(64), Item(53), Item(72), Item(63)),
                { Item(it.worryValue + 4) },
                Test(11, MonkeyId(3), MonkeyId(0)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(59), Item(79), Item(63)),
                { Item(it.worryValue * 7) },
                Test(17, MonkeyId(2), MonkeyId(7)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
            Monkey(
                mutableListOf(Item(55)),
                { Item(it.worryValue + 7) },
                Test(3, MonkeyId(2), MonkeyId(1)),
                {Item (it.worryValue % divisorInputMonkeys)}
            ),
        )


}