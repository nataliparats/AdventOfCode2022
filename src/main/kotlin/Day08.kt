fun countVisibleTrees(lines: List<String>): Int {
    val grid = lines.parseGrid()

    val columns = grid[0].size
    val rows = grid.size
    val boundaryTreeAmount = columns.times(2) + rows.times(2) -4

    var countVisibleTrees = 0
    for (x in 1 until rows-1)
        for (y in 1 until columns-1)
            if (checkIfTreeIsVisible(Point(x,y), grid))
                countVisibleTrees++

    return countVisibleTrees + boundaryTreeAmount
}

fun highestScenicScore(lines: List<String>): Int {
    val grid = lines.parseGrid()
    val columns = grid[0].size
    val rows = grid.size
    var highestScenicScore = 0

    for (x in 0 until rows) {
        for (y in 0 until columns) {
            val currentScenicScore = getScenicScore(x, y, grid)
            if (highestScenicScore < currentScenicScore)
                highestScenicScore = currentScenicScore
        }
    }
    return highestScenicScore
}

fun getScenicScore(x: Int, y: Int, grid: List<List<Int>>): Int {
    val treeInQuestion = grid[x][y]
    val fromTop = getAllTreesOnTop(x, y, grid).reversed()
    val fromBottom = getAllTreesOnBottom(x, y, grid)
    val fromLeft = getAllTreesOnLeft(x, y, grid).reversed()
    val fromRight = getAllTreesOnRight(x, y, grid)

    val topView = calculateViewDistance(fromTop, treeInQuestion)
    val bottomView = calculateViewDistance(fromBottom, treeInQuestion)
    val leftView = calculateViewDistance(fromLeft, treeInQuestion)
    val rightView = calculateViewDistance(fromRight, treeInQuestion)

    return topView * bottomView * leftView * rightView
}

private fun calculateViewDistance(neighbouringTrees: List<Int>, treeInQuestion: Int): Int {
    var countTrees = 0
    for (n in 1..neighbouringTrees.size) {
        if (treeInQuestion > neighbouringTrees[n-1])
            countTrees++
        else if (treeInQuestion <= neighbouringTrees[n-1])
            return ++countTrees
    }
    return countTrees
}

private fun List<String>.parseGrid() = map { line ->
    line
        .map { digit -> digit.digitToInt() }
}

private fun checkIfTreeIsVisible(currentTree: Point, grid: List<List<Int>>): Boolean {
    val fromTop = getAllTreesOnTop(currentTree.x, currentTree.y, grid)
    val fromBottom = getAllTreesOnBottom(currentTree.x, currentTree.y, grid)
    val fromLeft = getAllTreesOnLeft(currentTree.x, currentTree.y, grid)
    val fromRight = getAllTreesOnRight(currentTree.x, currentTree.y, grid)

    val currentTreeHeight = grid[currentTree.x][currentTree.y]
    if (isVisible(fromTop, currentTreeHeight) || isVisible(fromBottom, currentTreeHeight)
        || isVisible(fromLeft, currentTreeHeight) || isVisible(fromRight, currentTreeHeight))
        return true
    return false
}

fun isVisible(fromTop: List<Int>, currentTreeHeight: Int) =
    fromTop.none { it >= currentTreeHeight }

fun getAllTreesOnTop(x: Int, y: Int, grid: List<List<Int>>): List<Int> {
    val onTop = mutableListOf<Int>()
    for(n in 0 until x)
        onTop.add(grid[n][y])
    return onTop
}


private fun getAllTreesOnBottom(x: Int, y: Int, grid: List<List<Int>>): List<Int> {
    val onBottom = mutableListOf<Int>()
    for(n in x+1 until grid.size)
        onBottom.add(grid[n][y])
    return onBottom
}

private fun getAllTreesOnLeft(x: Int, y: Int, grid: List<List<Int>>): List<Int> {
    val onLeft = mutableListOf<Int>()
    for(n in 0 until y)
        onLeft.add(grid[x][n])
    return onLeft
}

private fun getAllTreesOnRight(x: Int, y: Int, grid: List<List<Int>>): List<Int> {
    val onRight = mutableListOf<Int>()
    for(n in y+1 until grid[0].size)
        onRight.add(grid[x][n])
    return onRight
}

data class Point(val x: Int, val y: Int)