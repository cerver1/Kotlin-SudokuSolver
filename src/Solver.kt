fun main(args: Array<String>){

    board1().forEach(::println)
    solve1(board1())


}

fun board1():MutableList<MutableList<Int>> {

    val listF = mutableListOf(0,0,8,2,0,0,9,0,3)
    val listG = mutableListOf(3,4,2,0,9,5,0,0,7)
    val listH = mutableListOf(1,9,7,0,0,0,0,0,4)

    val listI = mutableListOf(0,0,5,3,1,2,4,7,9)
    val listJ = mutableListOf(0,0,0,0,0,0,0,0,0)
    val listK = mutableListOf(2,0,0,0,7,4,5,0,0)

    val listL = mutableListOf(0,2,0,0,0,1,0,0,5)
    val listM = mutableListOf(0,7,0,0,0,6,8,9,1)
    val listN = mutableListOf(8,0,0,4,3,0,7,0,6)


    return mutableListOf(listF,listG,listH,listI,listJ,listK,listL,listM,listN)
}
fun solve1(board: MutableList<MutableList<Int>>):Boolean {
    //board.forEach(::println)
    println(board)
    val empty1 = findEmpty(board)
    if (empty1.isNullOrEmpty()) {
        return true }
    else{
        for (i in 1..10) {
            if (validate1(board, i , empty1)){
                board[empty1[0]][empty1[1]] = i

                if (solve1(board)){
                    return true
                }

                board[empty1[0]][empty1[1]] = 0
            }
        }

    }
    return  false
}
fun validate1(board: MutableList<MutableList<Int>>, number: Int, position: List<Int> ): Boolean{
    //Check Row
    if (board[position[0]].contains(number)) {
        return false }
    else {
        for (i in board[position[0]]){
            if (i == number ){  return false
            }
        }
    }

    return true
}
fun findEmpty(board: MutableList<MutableList<Int>>): List<Int> {

    for (i in board) {
        for (j in i){

            //row = i ,column = j
            if (j == 0) return listOf(board.indexOf(i), i.indexOf(j)) }

    }
    return emptyList()
}




