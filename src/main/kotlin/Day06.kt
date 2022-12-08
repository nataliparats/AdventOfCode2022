/**
 * the first position where the four most recently received characters were all different.
 * Specifically, it needs to report the number of characters from the beginning of the buffer to
 * the end of the first such four-character marker.
 */
fun findRequiredPosition(datastream: String, amountOfDistinctChar: Int): Int {
    val buffer = mutableListOf<Char>()
    val dataStreamArray = datastream.toCharArray()
    for ((index, value) in dataStreamArray.withIndex()) {
        buffer.add(value)
        if (buffer.size == amountOfDistinctChar && buffer.toSet().size == amountOfDistinctChar)
            return index+1
        else if (buffer.size == amountOfDistinctChar)
            buffer.removeFirst()
    }
    return 0
}