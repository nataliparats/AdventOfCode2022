class Day14 {

    companion object {

        val startingPoint = Point(500, 0)

        fun createPaths(lines: List<String>): HashSet<Day14.Point> {
            val parsedInput = parseInput(lines)
            return parsedInput.flatMap { createPath(it) }.toHashSet()
        }

        fun parseInput(lines: List<String>) = lines.map { line ->
                line.split(" -> ")
                    .map { coordinate ->
                        val (x, y) = coordinate.split(",").map { it.toInt() }
                        Point(x, y)
                    }
            }

        fun createPath(path: List<Point>) =
            path.windowed(2).flatMap { (from, to) ->
                val (minX, maxX) = listOf(from.x, to.x).sorted()
                val (minY, maxY) = listOf(from.y, to.y).sorted()
                (minX..maxX).flatMap { x ->
                    (minY..maxY).map { y ->
                        Point(x, y)
                    }
                }
            }.toSet()



    }
    data class Point(val x: Int, val y: Int) {
        fun down() = this.copy(y = y + 1)
        fun right() = this.copy(x = x + 1, y = y + 1)
        fun left() = this.copy(x = x - 1, y = y + 1)
    }

    data class GridPart1(val rocks: Set<Point>) {

        fun keepPouring(): Int {
            var oldGrid = this
            var newGrid = this

            do  {
                oldGrid = newGrid
                newGrid = newGrid.pourSand()
            } while(oldGrid != newGrid)
            return newGrid.rocks.size - this.rocks.size
        }

        fun pourSand(): GridPart1 {
            var sandPosition = startingPoint
            do {
                when {
                    sandPosition.y > maxY ->
                        return this
                    sandPosition.down() !in rocks ->
                        sandPosition = sandPosition.down()
                    sandPosition.left() !in rocks ->
                        sandPosition = sandPosition.left()
                    sandPosition.right() !in rocks ->
                        sandPosition = sandPosition.right()
                    else ->
                        return GridPart1 (rocks + sandPosition)
                }
            } while (true)
        }

        val maxY = rocks.maxOf { it.y }
    }


    data class GridPart2(val rocks: Set<Point>, val maxY: Int = rocks.maxOf { it.y + 2}) {

        fun keepPouring(): Int {
            var oldGrid = this
            var newGrid = this

            do  {
                oldGrid = newGrid
                newGrid = newGrid.pourSand()
            } while(oldGrid != newGrid)
            return newGrid.rocks.size - this.rocks.size
        }

        fun isFree(point: Point) = !rocks.contains(point) && point.y < maxY

        fun pourSand(): GridPart2 {
            var sandPosition = startingPoint
            var i = 0
            do {
                i++
                when {
                    rocks.contains(startingPoint) -> return this
                    isFree(sandPosition.down()) ->
                        sandPosition = sandPosition.down()
                    isFree(sandPosition.left()) ->
                        sandPosition = sandPosition.left()
                    isFree(sandPosition.right()) ->
                        sandPosition = sandPosition.right()
                    else ->
                        return copy (rocks = rocks + sandPosition, maxY = maxY)
                }
            } while (true)
        }


    }
}
