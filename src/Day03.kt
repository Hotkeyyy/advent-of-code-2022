import java.io.File

fun main() {

    val lowerCase = ('a'..'z').toList()
    val upperCase = ('A'..'Z').toList()

    fun part1(input: String) {
        var result = 0
        input.split("\r").map { it.trim() }.forEach {
            val firstCompartment = it.substring(0, it.length / 2)
            val secondCompartment = it.substring(it.length / 2, it.length)
            var sameCharacter = ' '
            secondCompartment.forEach { c -> if (firstCompartment.contains(c)) sameCharacter = c }
            if (lowerCase.contains(sameCharacter)) result += (lowerCase.indexOf(sameCharacter) + 1)
            if (upperCase.contains(sameCharacter)) result += (upperCase.indexOf(sameCharacter) + 27)
        }
        println(result)
    }

    fun part2(input: String) {
        var result = 0
        input.split("\r").map { it.trim() }.chunked(3).forEach { list ->
            var sameCharacter = ' '
            list.first().forEach { c ->
                var lastContains = true
                list.forEach {
                    if (lastContains && !it.contains(c)) lastContains = false
                }
                if (lastContains) sameCharacter = c
            }
            if (lowerCase.contains(sameCharacter)) result += (lowerCase.indexOf(sameCharacter) + 1)
            if (upperCase.contains(sameCharacter)) result += (upperCase.indexOf(sameCharacter) + 27)
        }
        println(result)

    }

    val input = File("src/Day03.txt").readText()
    part1(input)
    part2(input)
}