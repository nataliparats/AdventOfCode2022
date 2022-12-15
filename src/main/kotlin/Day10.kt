
class Day10 {
    companion object {

        fun calculateOutput(lines: List<String>): String {
            val instructions = parseInput(lines)
            return resultAfterEveryCycle(instructions).chunked(40).take(6)
                .map { line ->
                    line.mapIndexed { index, windowPosition ->
                        if (index in listOf(windowPosition - 1, windowPosition, windowPosition + 1)) '#'
                        else '.'
                    }.joinToString("")
                }.joinToString ("\n" )
        }

        fun calculateSignalStrength(lines: List<String>): Int {
            val instructions = parseInput(lines)
            return resultAfterEveryCycle(instructions).let {instructionResults ->
                (20 .. 220 step 40).sumOf { cycle ->
                    cycle * instructionResults[cycle - 1] }
            }
        }
        fun calculateSingalStrengthPerCycleNumber(lines: List<String>, cycleNumber: Int? = null): Int {
            val instructions = parseInput(lines)

            val result = resultAfterEveryCycle(instructions)
            return cycleNumber!! * result[cycleNumber!!.minus(1)]
        }

        private fun resultAfterEveryCycle(instructions: List<Instruction>): List<Int> {
            var x = 1 // initial value
            val valueAtEveryStep = instructions.flatMap { instruction ->
                val mutatedValues = instruction.execute(x)
                x = mutatedValues.last()
                mutatedValues
            }
            val result = listOf(1) + valueAtEveryStep
            return result
        }

        fun parseInput(lines: List<String>): List<Instruction> =
            lines.map { line ->
                line.trim()
                if (line.startsWith("addx"))
                    Addition(line.split(" ").last().toInt())
                else
                    Noop
            }

        sealed interface Instruction {
            fun execute(currentValue: Int): List<Int>
        }

        data class Addition(val value: Int) : Instruction {
            override fun execute(currentValue: Int) =
                listOf(currentValue, currentValue + value)
        }

        object Noop : Instruction {
            override fun execute(currentValue: Int) =
                listOf(currentValue)
        }
    }
}
