import java.io.File

val meL = "XYZ".toList()
val opponentL = "ABC".toList()
fun main() {
    fun part1(input: String) {
        val rounds = input.split("\r")
        var result = 0
        rounds.forEach {
            val me = it.split(" ").last()
            val opponent = it.split(" ").first()
            val p = getPoints(
                Pair(
                    meL.indexOf(me.trim().toCharArray().first()),
                    opponentL.indexOf(opponent.trim().toCharArray().first())
                )
            )
            result += p
        }
        println(result)
    }

    fun part2(input: String) {
        val rounds = input.split("\r")
        var result = 0
        rounds.forEach {
            val type = it.split(" ").last()
            val opponent = it.split(" ").first()
            var character = ""
            when (type) {
                "X" -> character = opponent.trim().characterToLose
                "Y" -> character = opponent.trim().characterToDraw
                "Z" -> character = opponent.trim().characterToWin
            }
            val p = getPoints(
                Pair(
                    meL.indexOf(character.trim().toCharArray().first()),
                    opponentL.indexOf(opponent.trim().toCharArray().first())
                )
            )
            result += p
        }
        println(result)


    }

    val input = File("src/Day02.txt").readText()
    part2(input)

}

val String.characterToWin: String
    get() {
        if (this == "A") return "Y"
        if (this == "B") return "Z"
        if (this == "C") return "X"
        return TODO("Provide the return value")
    }

val String.characterToDraw: String
    get() {
        return meL[opponentL.indexOf(this.trim().toCharArray().first())].toString()
    }

val String.characterToLose: String
    get() {
        if (this == "A") return "Z"
        if (this == "B") return "X"
        if (this == "C") return "Y"
        return TODO("Provide the return value")
    }


fun getPoints(pair: Pair<Int, Int>): Int {
    val me = pair.first
    val opponent = pair.second
    var points = 0
    if (me == opponent) points += 3
    if (me == 0 && (opponent == 2)) points += 6
    if (me == 1 && (opponent == 0)) points += 6
    if (me == 2 && (opponent == 1)) points += 6

    if (me == 0) points += 1
    if (me == 1) points += 2
    if (me == 2) points += 3

    return points
}