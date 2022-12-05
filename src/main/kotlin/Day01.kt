fun calculateMostCalories(lines: List<String>): Int {

    var current = 0
    var maxCalories = 0
    lines.forEach { line ->
        if(line.isNotEmpty())  {
            current += line.toInt()
        } else {
            if (current >= maxCalories)
                maxCalories = current

            current = 0 //reset current
        }
    }

    return maxCalories
}

fun calculateTop3Calories (lines: List<String>): Int {

    var sumOfCaloriesPerElf = mutableListOf<Int>()
    var current = 0
    (lines + "").forEach { line ->
        if (line.isNotEmpty()) {
            current += line.toInt()
        } else {
            sumOfCaloriesPerElf.add(current)
            current = 0 //reset current
        }
    }

    return sumOfCaloriesPerElf.sortedDescending().take(3).sum()
}

