fun levelOfMonkeyBusiness(monkeys: List<Monkey>, rounds: Int): Item =
    KeepAway(monkeys).let {
        it.doRounds(rounds)
        val (monkey1, monkey2) = monkeys.map { monkey ->
            monkey.inspectedItemCount
        }.sortedDescending()
            .take(2)
        Item(monkey1 * monkey2)
    }

class KeepAway(private val monkeys: List<Monkey>) {
    fun doRounds(count: Int) {
        repeat(count) {
//            if (it % 20 == 0)
//                println("== After round $it ==")

            monkeys.forEachIndexed { index, monkey ->
                monkey.turn().forEach { (thrownItem, monkeyId) ->
                    monkeys[monkeyId.id].items.add(thrownItem)
                }
                monkey.items.clear()

//                if (it % 20 == 0)
//                    println("Monkey $index inspected items ${monkey.inspectedItemCount} times.")
            }
        }
    }
}

@JvmInline
value class MonkeyId(val id: Int)

@JvmInline
value class Item(val worryValue: Long)
class Monkey(
    val items: MutableList<Item> = mutableListOf(),
    val operation: (Item) -> Item,
    val test: Test,
    val decreaseWorryLevel: (Item) -> Item = {Item (it.worryValue / 3)}
) {
    var inspectedItemCount = 0L
    fun turn() =
        items.map { item->
            inspectedItemCount++
            operation(item)
        }
            .map { decreaseWorryLevel(it) }
            .map { item -> `throw`(item to test(item)) }

    private fun `throw`(itemToMonkey: Pair<Item, MonkeyId>) = itemToMonkey
}

class Test(
    private val divisor: Int,
    private val onTrue: MonkeyId,
    private val onFalse: MonkeyId
): (Item) -> MonkeyId {
    override fun invoke(item: Item): MonkeyId =
        if (item.worryValue % divisor == 0L) onTrue else onFalse
}