fun readLines(filePath: String) =
    object {}.javaClass.classLoader.getResource(filePath)
        ?.readText()
        ?.lines()!!
fun readText(filePath: String) =
    object {}.javaClass.classLoader.getResource(filePath)
        ?.readText()