fun calculateRockPaperScissorsScorePart1(lines: List<String>): Int = lines.sumOf { line ->
        (calculateScoreFromMovePart1(line) + calculateBattleScorePart1(line))
    }

fun calculateRockPaperScissorsScorePart2(lines: List<String>): Int = lines.sumOf { line ->
    (calculateScoreFromMovePart2(line) + calculateBattleScorePart2(line))
}

private fun calculateBattleScorePart2(line: String) =
    when(line[2]) {
        'X' -> 0
        'Y' -> 3
        'Z' -> 6

        else -> 0
    }

private fun calculateScoreFromMovePart2(line: String): Int {
    val opponentMove = line[0]
    return when (line[2]) {
        'X'-> {
            when(opponentMove) {
                'A' -> 3
                'B' -> 1
                'C' -> 2
                else -> 0
            }
        }
        'Y' -> {
            when(opponentMove) {
                'A' -> 1
                'B' -> 2
                'C' -> 3
                else -> 0
            }
        }
        'Z' ->
            when(opponentMove) {
                'A' -> 2
                'B' -> 3
                'C' -> 1
                else -> 0
            }
        else -> 0
    }
}

private fun calculateBattleScorePart1(line: String): Int {
    val opponentMove = line[0]
    val ownMove = line[2]
    return when (opponentMove to ownMove) {
        'A' to 'Y',
        'B' to 'Z',
        'C' to 'X'-> 6
        'A' to 'X',
        'B' to 'Y',
        'C' to 'Z' -> 3

        else -> 0
    }
}

private fun calculateScoreFromMovePart1(line: String) =
    when (line[2]) {
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> 0
    }