import java.io.File

fun main() {
    fun part1(input: String) {
        val elfs = input.split("\r\n\r\n")
        println(findHighestElf(elfs))
    }

    fun part2(input: String) {
        val elfs = input.split("\r\n\r\n").toMutableList()
        var r = 0
        for (i in 0..2) {
            val elf = findHighestElf(elfs)
            elfs.removeAt(elf.second)
            r += elf.first
        }
        println(r)
    }

    val input = File("src/Day01.txt").readText()
    part2(input)
}

fun findHighestElf(elfs: List<String>): Pair<Int, Int> {
    var result = 0
    var index = 0
    elfs.forEachIndexed { ind, it ->
        val cals = it.split("\r\n")
        var a = 0
        cals.forEach { s ->
            a += s.toInt()
        }
        if (a > result) {
            result = a
            index = ind
        }
    }
    return Pair(result, index)
}