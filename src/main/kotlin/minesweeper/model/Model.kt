package minesweeper

import minesweeper.CellData.*

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

enum class ClickMode {
    OPENING,
    FLAGGED
}

enum class CellData(private val textValue: String) {
    MINE("*"),
    FLAG("P"),
    CLOSEDC("_"),//closed filed
    OPENEDC(" "),// open filed with number of mines around or empty
}

open class Cell(var cell: CellData)

class OpenedCell(var number: Int) : Cell(OPENEDC)

enum class State(val textValue: String) {
    LOSE("u lose, game finished"),
    WIN("u win, game finished"),
    IN("u're playing, game is going")
}

val GameFinished = setOf(State.WIN, State.LOSE)

interface ModelChangeListener {
    fun onModelChanged()
}

private const val MAXSIDE: Int = 25
private const val MAXMINES = 99

class Model(private val rows: Int, private val cols: Int, private var mines: Int) {

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    val size = rows * cols

    var dataBoard: MutableList<MutableList<Cell>> = MutableList(rows) { MutableList(cols) { OpenedCell(0) } }

    //var board: MutableList<MutableList<Cell>>= MutableList(rows) { MutableList(cols) { Cell<CellData.OPENEDC> }
    var board: MutableList<MutableList<Cell>> = MutableList(rows) { MutableList(cols) { Cell(CLOSEDC) } }
    var minePosition: MutableList<Pair<Int, Int>> = MutableList(0) { Pair(0, 0) }
    private var minesLeft = mines
    private var flagsLeft = mines
    var movesLeft = cols * rows// need to understand first move(on first move u can't open mine
    var clickMode = ClickMode.OPENING

    var state = State.IN

    init {
        require(rows in 1..99) { "wrong rows number" }
        require(cols in 1..99) { "wrong col number" }
        require(mines in 1..cols * rows) { "wrong mines number" }
        flagsLeft = mines
        state = State.IN
        board = MutableList(rows) { MutableList(cols) { Cell(CLOSEDC) } }
        placeMines()
    }

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun isValid(row: Int, col: Int): Boolean {//check for correctly input
        // Returns true if row number and column number
        // is in range
        return (row in 0 until cols) &&
                (col in 0 until rows)
    }

    private fun placeMines() {// set positions of mines
        var i = 0
        var y: Int
        var x: Int
        while (i < mines) {
            y = (0 until rows).random()
            x = (0 until cols).random()
            if (dataBoard[y][x].cell != MINE) {
                dataBoard[y][x].cell = MINE
                minePosition.add(Pair(y, x))
                i++
            }
        }
    }

    private fun replaceMine(row: Int, col: Int) {//replace mine if it spawns under the mouse in the first move
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (dataBoard[i][j].cell == OPENEDC) {
                    dataBoard[i][j].cell = MINE
                    dataBoard[row][col].cell = OPENEDC
                    minePosition.remove(Pair(row, col))
                    minePosition.add((Pair(i, j)))
                    return
                }
            }
        }
    }

    fun switchMode() {//switch to opening the cell or to put flag on it
        clickMode = if (clickMode == ClickMode.OPENING) ClickMode.FLAGGED else ClickMode.OPENING
    }

    fun isMine(row: Int, col: Int): Boolean {
        return board[row][col].cell == MINE
    }


    private fun countAdjacentMines( //count number of mines around the cur cell
        row: Int, col: Int, board: MutableList<MutableList<Cell>>, cell: CellData
    ): Int {

        var count = 0

        /*
            Count all the mines in the 8 adjacent
            cells

                N.W   N   N.E
                  \   |   /
                   \  |  /
                W----Cell----E
                     / | \
                   /   |  \
                S.W    S   S.E

            Cell-->Current Cell (row, col)
            N -->  North        (row-1, col)
            S -->  South        (row+1, col)
            E -->  East         (row, col+1)
            W -->  West            (row, col-1)
            N.E--> North-East   (row-1, col+1)
            N.W--> North-West   (row-1, col-1)
            S.E--> South-East   (row+1, col+1)
            S.W--> South-West   (row+1, col-1)
        */

        //----------- 1st Neighbour (North) ------------
        // Only process this cell if this is a valid one
        if (isValid(row - 1, col)) {
            if (board[row - 1][col].cell == cell)
                count++
        }

        //----------- 2nd Neighbour (South) ------------
        // Only process this cell if this is a valid one
        if (isValid(row + 1, col)) {
            if (board[row + 1][col].cell == cell)
                count++
        }

        //----------- 3rd Neighbour (East) ------------
        // Only process this cell if this is a valid one
        if (isValid(row, col + 1)) {
            if (board[row][col + 1].cell == cell)
                count++
        }

        //----------- 4th Neighbour (West) ------------
        // Only process this cell if this is a valid one
        if (isValid(row, col - 1)) {
            if (board[row][col - 1].cell == cell)
                count++
        }

        //----------- 5th Neighbour (North-East) ------------
        // Only process this cell if this is a valid one
        if (isValid(row - 1, col + 1)) {
            if (board[row - 1][col + 1].cell == cell)
                count++
        }

        //----------- 6th Neighbour (North-West) ------------
        // Only process this cell if this is a valid one
        if (isValid(row - 1, col - 1)) {
            if (board[row - 1][col - 1].cell == cell)
                count++
        }

        //----------- 7th Neighbour (South-East) ------------
        // Only process this cell if this is a valid one
        if (isValid(row + 1, col + 1)) {
            if (board[row + 1][col + 1].cell == cell)
                count++
        }

        //----------- 8th Neighbour (South-West) ------------
        // Only process this cell if this is a valid one
        if (isValid(row + 1, col - 1)) {
            if (board[row + 1][col - 1].cell == cell)
                count++
        }

        return (count)
    }

    private fun autoRevealAdjacentFields(row: Int, col: Int) {// fun to summon/(call up) functions to opening cells
        val flags = countAdjacentMines(row, col, board, FLAG)
        if (flags >= (board[row][col] as OpenedCell).number) {
            revealAdjacentCells(row, col)
        }
    }


    private fun revealAdjacentCells(row: Int, col: Int) {
        for (i in -1..1) {
            for (j in -1..1) {
                if (isValid(row + i, col + j) && !((i == 0) && (j == 0))) {
                    if (board[row + i][col + j].cell != FLAG) {
                        revealCell(row + i, col + j)
                    }
                }
            }
        }
    }

    private fun revealCell(row: Int, col: Int) {
        if (board[row][col].cell == OPENEDC) return//nothing to do
        if (dataBoard[row][col].cell == MINE) {//opened wrong cell
            state = State.LOSE
            board[row][col].cell = MINE
            minePosition.remove(Pair(row, col))
            return
        }
        movesLeft--
        //println("countAdjacentMines")
        val mine = countAdjacentMines(row, col, dataBoard, MINE)
        //println("OpenedCell")
        val newCell = OpenedCell(mine)
        board[row][col] = newCell
        // printBoard()
        if (mine == 0) {//opened empty cell and need to open more around
            //  println("revealAdjacentCells")
            revealAdjacentCells(row, col)
        }
    }

    fun printBoard() {
        var res = ""
        board.forEach { it ->
            it.forEach {

                if (it.cell == FLAG) res += "P"
                if (it.cell == MINE) res += "*"
                if (it.cell == OPENEDC) res += (it as OpenedCell).number
                if (it.cell == CLOSEDC) res += "_"
            }
        }
        //println(res)
        for (i in 0..res.length - 1) {
            if (i % 9 == 0) println()
            print(res[i] + " ")

        }
    }

    fun printDataBoard() {
        var res = ""
        dataBoard.forEach { it ->
            it.forEach {

                if (it.cell == FLAG) res += "P"
                if (it.cell == MINE) res += "*"
                if (it.cell == OPENEDC) res += (it as OpenedCell).number
                if (it.cell == CLOSEDC) res += "_"
            }
        }
        //println(res)
        for (i in res.indices) {
            if (i % 9 == 0) println()
            print(res[i] + " ")

        }
    }


    fun doMove(col: Int, row: Int) {
        require(state !in GameFinished) { "Game finished" }
        require(isValid(row, col)) { "wrong move" }
        //val c=
        val gameCell = board[row][col].cell
        if ((gameCell == OPENEDC) && (board[row][col] as OpenedCell).number != 0) {
            //  println("\nautoReveal")
            autoRevealAdjacentFields(row, col)
        } else {
            if (clickMode == ClickMode.OPENING) {
                //    println("\n opening")
                if ((movesLeft == rows * cols) && (dataBoard[row][col].cell == MINE)) {
                    //      println("\n first opening")
                    replaceMine(row, col)
                    revealCell(row, col)
                } else if (gameCell == CLOSEDC) {
                    //    println("\n not first opening")
                    revealCell(row, col)
                }
            }
            if (clickMode == ClickMode.FLAGGED) {
                flaggedCell(row, col)
            }
        }
    }

    private fun flaggedCell(rows: Int, cols: Int) {
        val cell = board[rows][cols].cell
        if (cell == FLAG) {//to delete set earlier flag
            board[rows][cols].cell = FLAG
            minesLeft++

            if (dataBoard[rows][cols].cell == MINE) {
                movesLeft++
            }
        } else {
            if (cell == CLOSEDC) {//set new flag
                board[rows][cols].cell = FLAG
                minesLeft--
                if (dataBoard[rows][cols].cell == MINE) {
                    movesLeft--
                }
            }
        }
    }

    private fun checkWin(): Boolean {
        return true
    }

    private fun checkLose(): Boolean {
        return true
    }

}
