fun readLines(filePath: String) =
    object {}.javaClass.classLoader.getResource(filePath)
        ?.readText()
        ?.lines()!!
