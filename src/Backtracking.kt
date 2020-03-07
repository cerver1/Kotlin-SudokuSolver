import java.util.stream.IntStream.range

fun main(args: Array<String>){

    println("")
    println("Starting Board")
    board4().forEach(::println)
    println("")
    println("Solved Board")
    solve1(board4())

    //println(findEmpty(board2()))

}
//Beginner
fun board1():List<MutableList<Int>> {

    val list1 = mutableListOf(0,0,9,0,0,2,0,0,5)
    val list2 = mutableListOf(5,3,8,0,6,4,0,0,9)
    val list3 = mutableListOf(1,6,2,0,0,0,0,3,0)
    val list4 = mutableListOf(0,0,3,0,2,7,0,0,0)
    val list5 = mutableListOf(0,5,4,6,0,0,1,0,0)
    val list6 = mutableListOf(0,0,7,0,1,5,3,4,0)
    val list7 = mutableListOf(3,0,0,8,0,1,9,0,6)
    val list8 = mutableListOf(7,0,0,3,0,0,8,5,0)
    val list9 = mutableListOf(0,9,1,0,0,0,4,7,0)


    return listOf(list1,list2,list3,list4,list5,list6,list7,list8,list9)
}

//Expert
fun board4():List<MutableList<Int>> {

    val list1 = mutableListOf(3,0,0,1,0,0,0,8,0)
    val list2 = mutableListOf(0,0,0,0,6,0,0,0,4)
    val list3 = mutableListOf(5,6,0,2,0,0,0,0,0)
    val list4 = mutableListOf(0,3,0,0,0,8,1,0,2)
    val list5 = mutableListOf(6,0,0,0,0,0,0,7,0)
    val list6 = mutableListOf(0,0,0,0,0,4,5,0,0)
    val list7 = mutableListOf(0,0,1,0,0,9,7,0,0)
    val list8 = mutableListOf(0,0,0,0,0,0,0,9,0)
    val list9 = mutableListOf(0,2,0,0,8,0,0,0,0)


    return listOf(list1,list2,list3,list4,list5,list6,list7,list8,list9)
}

fun solve1(board: List<MutableList<Int>>):Boolean {
    //board.forEach(::println)
    //
    val position = findEmpty(board)
    if (position.isEmpty()) {
        board.forEach(::println)
        return true}
    else{
        for (i in 1..9) {
            if (validate1(board, i , position)){
                board[position[0]][position[1]] = i

                if (solve1(board)){
                    return true
                }

                board[position[0]][position[1]] = 0
            }
        }

    }
    return  false
}
fun validate1(board: List<List<Int>>, number: Int, position: List<Int> ): Boolean{
    //check row
    if (board[position[0]].contains(number)) { return false }
    //check column
    for (i in board) {
        if (i[position[1]] == number){ return false} }

    val cordX = position[1] / 3
    val cordY = position[0] / 3


    for (i in range(cordY*3, (cordY*3)+ 3)){
        for (j in range(cordX*3, (cordX*3)+3)){
            if (board[i][j] == number && listOf(i,j) != position) {return false}
        }
    }

    return true
}
fun findEmpty(board: List<List<Int>>): List<Int> {

    for (i in board) {
        for (j in i){

            //row = i ,column = j
            if (j == 0) return listOf(board.indexOf(i), i.indexOf(j)) }

    }
    return emptyList()
}


