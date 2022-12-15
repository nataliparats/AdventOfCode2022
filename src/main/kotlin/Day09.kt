import Day09.Companion.Direction.*
import kotlin.math.abs

class Day09 {
    companion object {

        fun day09part1(lines: List<String>): Int {
            return pointsVisitedByTail(lines, 2)
        }

        fun day09part2(lines: List<String>): Int {
            return pointsVisitedByTail(lines, 10)
        }

        private fun pointsVisitedByTail(lines: List<String>, ropeLength: Int): Int {
            val headMovements = lines.parseHeadMovements()
            var rope = List(ropeLength) { Point(0, 0) }
            val pointsVisitedByTail = mutableSetOf(Point(0, 0))
            headMovements.forEach { move ->
                val newRope = mutableListOf<Point>()
                rope.forEachIndexed { index, point ->
                    newRope.add(if (index == 0) point.move(move) else point.moveTowards(newRope.last()))
                }
                pointsVisitedByTail.add(newRope.last())
                rope = newRope
            }

            return pointsVisitedByTail.size
        }

        private fun List<String>.parseHeadMovements(): List<Direction> {
            return this.flatMap { line ->
                val (direction, count) = line.split(" ")
                when (direction) {
                    "U" -> UP
                    "D" -> DOWN
                    "R" -> RIGHT
                    "L" -> LEFT
                    else -> throw IllegalArgumentException()
                }.let { parsedDirection ->
                    List(count.toInt()) { parsedDirection }
                }
            }
        }

        enum class Direction {
            UP,
            DOWN,
            RIGHT,
            LEFT,
        }

        data class Point(val x: Int, val y: Int) {
            fun move(move: Direction) = when (move) {
                UP -> copy(y = y + 1)
                DOWN -> copy(y = y - 1)
                RIGHT -> copy(x = x + 1)
                LEFT -> copy(x = x - 1)
            }

            fun moveTowards(point: Point): Point {
                val diffx = x - point.x
                val diffy = y - point.y

                //points touch
                if (diffx in (-1..1) && diffy in (-1..1)) {
                    return this
                }

                // if difference is 2 in 1 axes and 1 in another axes
                if (abs(diffx) == 2 && abs(diffy) == 1) {
                    return this.copy(y = point.y).moveTowards(point)
                }
                if (abs(diffy) == 2 && abs(diffx) == 1) {
                    return this.copy(x = point.x).moveTowards(point)
                }

                val newx = when (diffx) {
                    2 -> x - 1
                    -2 -> x + 1
                    else -> x
                }
                val newy = when (diffy) {
                    2 -> y - 1
                    -2 -> y + 1
                    else -> y
                }
                return Point(newx, newy)
            }
        }
    }
}
