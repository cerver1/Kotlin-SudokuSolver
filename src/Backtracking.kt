import java.util.stream.IntStream.range
import kotlin.system.measureTimeMillis

fun main(args: Array<String>){

    println("\nStarting Board\n")
    (zeroedBoard()).map { it.contentToString() }.forEach(::println)

    val time = measureTimeMillis {

        println("\nSolved Board\n")
        findSolution(zeroedBoard()).map { it.contentToString() }.forEach(::println)

    }

    println("\nsolved in $time ms\n")

}

fun zeroedBoard() = (1..9).map {
    (1..9).map { 0 }.toTypedArray()
}.toTypedArray()

//Beginner
fun beginnerSudokuBoard() = arrayOf(

    arrayOf(0,0,9,0,0,2,0,0,5),
    arrayOf(5,3,8,0,6,4,0,0,9),
    arrayOf(1,6,2,0,0,0,0,3,0),
    arrayOf(0,0,3,0,2,7,0,0,0),
    arrayOf(0,5,4,6,0,0,1,0,0),
    arrayOf(0,0,7,0,1,5,3,4,0),
    arrayOf(3,0,0,8,0,1,9,0,6),
    arrayOf(7,0,0,3,0,0,8,5,0),
    arrayOf(0,9,1,0,0,0,4,7,0)

)

//Expert
fun expertSudokuBoard() = arrayOf(
    arrayOf(3,0,0,1,0,0,0,8,0),
    arrayOf(0,0,0,0,6,0,0,0,4),
    arrayOf(5,6,0,2,0,0,0,0,0),
    arrayOf(0,3,0,0,0,8,1,0,2),
    arrayOf(6,0,0,0,0,0,0,7,0),
    arrayOf(0,0,0,0,0,4,5,0,0),
    arrayOf(0,0,1,0,0,9,7,0,0),
    arrayOf(0,0,0,0,0,0,0,9,0),
    arrayOf(0,2,0,0,8,0,0,0,0)
)

fun findSolution(board: Array<Array<Int>>) : Array<Array<Int>> {

    val position = findEmptyPosition(board)

    if (position.isEmpty()) {
        return board
    } else {

        (1..9).forEach { candidate ->

            if (validatePlacement(board, candidate, position)) {

                board[position[0]][position[1]] = candidate

                if (findEmptyPosition(findSolution(board)).isEmpty()) return board

                board[position[0]][position[1]] = 0
            }

        }

        return board

    }

}

private fun validatePlacement(
    board: Array<Array<Int>>,
    number: Int,
    position: List<Int>
): Boolean {
    // validate row
    if (board[position[0]].contains(number)) return false

    // validate column
    for (i in board) {
        if (i[position[1]] == number) return false
    }

    val x = position[1] / 3
    val y = position[0] / 3

    for (row in range(y*3, (y*3)+ 3)){
        for (column in range(x*3, (x*3)+3)){
            if (board[row][column] == number && listOf(row,column) != position) return false
        }
    }

    return true
}

private fun findEmptyPosition(board: Array<Array<Int>>): List<Int> {

    for (row in board) {
        for (column in row) {
            if (column == 0) return listOf(board.indexOf(row), row.indexOf(column))
        }
    }
    return emptyList()
}