package minesweeper

import minesweeper.view.MineSweeperUI
import javax.swing.SwingUtilities
import minesweeper.controller.Controller
import minesweeper.Model


fun main() {
    SwingUtilities.invokeLater {
        val mineSweeperUI = MineSweeperUI()
        mineSweeperUI.isVisible = true
    }
//rog zephrrus m16 gu603hr-k8013t

/*

    val game=Model(9,9,10)
    game.printBoard()
    println("\n and data is")
    game.printDataBoard()

    var x:Int=readln().toInt()
    var y: Int=readln().toInt()
    println("\n left=${game.movesLeft}")
    game.doMove(x,y)
       game.switchMode()
    game.printBoard()
     x=readln().toInt()
     y=readln().toInt()
       game.doMove(x,y)
    game.printBoard()
    println("\n and data is")
    game.printDataBoard()
*/
    // println ("asd")
}