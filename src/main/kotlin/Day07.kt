fun totalSizeOfDirWithLessThan100000Size(lines: List<String>): Int {
    val fileSystem = parseFileSystem(lines)

    return fileSystem.allChildren().filter { it.size() <= 100_000 }.sumOf { it.size() }
}

fun findSizeOfDirectoryToDelete(lines: List<String>): Int {
    val fileSystem = parseFileSystem(lines)

    val freeSpace = 70000000 - fileSystem.size()
    val extraSpaceToClear = 30000000 - freeSpace

    return fileSystem.allChildren().filter { it.size() >= extraSpaceToClear }.minOf { it.size() }
}

private fun parseFileSystem(lines: List<String>): Directory {
    var root = Directory("/")
    var currentDirectory = root

    val dirPrefix = "dir "
    val cdPrefix = "\$ cd "
    lines.drop(1).forEach { line ->
        if (line.startsWith(dirPrefix))
            currentDirectory.children.add(Directory(line.drop(dirPrefix.length), currentDirectory))
        else if (line.matches("[0-9]+ [a-z.]+".toRegex())) {
            val (size, name) = line.split(" ")
            currentDirectory.children.add(File(name, size.toInt()))
        } else if (line == "\$ cd ..") {
            currentDirectory = currentDirectory.parent!!
        } else if (line.startsWith(cdPrefix)) {
            currentDirectory = currentDirectory.children.first { it.name == line.drop(cdPrefix.length) } as Directory
        }
    }

    return root
}

sealed interface FileSystem {
    val name: String

    fun size (): Int =
        when(this) {
            is File -> size
            is Directory -> children.sumOf{it.size()}
        }
}
data class Directory(
    override val name: String,
    val parent: Directory? = null,
    val children: MutableList<FileSystem> = mutableListOf(),
) : FileSystem {

    fun allChildren(): List<Directory> = children.filterIsInstance<Directory>().flatMap { it.allChildren() } + this

}
data class File(
    override val name: String,
    val size: Int
) : FileSystem

