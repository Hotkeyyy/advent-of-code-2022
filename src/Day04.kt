import java.io.File

fun main() {
    fun part1(input: String) {
        val pairs = input.split("\n").map {
            val parts = it.split(",")
            Pair(parts[0].split("-").map { it.toInt() }, parts[1].split("-").map { it.toInt() })
        }
        val count = pairs.count {
            val (a, b) = it
            (a[0] <= b[0] && a[1] >= b[1]) || (b[0] <= a[0] && b[1] >= a[1])
        }
        println(count)
    }

    fun part2(input: String) {
        val pairs = input.split("\n").map {
            val parts = it.split(",")
            Pair(parts[0].split("-").map { it.toInt() }, parts[1].split("-").map { it.toInt() })
        }
        val count = pairs.count {
            val (a, b) = it
            (a[0] <= b[1] && a[1] >= b[0]) || (b[0] <= a[1] && b[1] >= a[0])
        }
        println(count)
    }

    val input = File("src/Day04.txt").readText()
    part1(input)
    part2(input)
}