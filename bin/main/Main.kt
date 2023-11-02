import java.io.File

fun main(args: Array<String>) {
    val currentPath = System.getProperty("user.dir")
    val dataDir = "hotel-simulator_data"
    val filePath = "$currentPath/hotel-simulator.scmp"

    val file = File(filePath)
    val modifiedLines = mutableListOf<String>()

    file.forEachLine { line ->
        val modifiedLine = line.takeIf{it.contains("file:")}?.replace(Regex("\"(.*?)/$dataDir"),
            "\"$currentPath/$dataDir"
        ) ?: line
        modifiedLines.add(modifiedLine)
    }

    file.writeText(modifiedLines.joinToString("\n"))
}