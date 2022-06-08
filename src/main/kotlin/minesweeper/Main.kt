package minesweeper

import minesweeper.view.MineSweeperUI
import javax.swing.SwingUtilities

fun main() {


    SwingUtilities.invokeLater {
        val mineSweeperUI = MineSweeperUI()
        mineSweeperUI.isVisible = true
    }


//rog zephrrus m16 gu603hr-k8013t


/*
    val game=Model(2,2,1)
    game.printBoard()
    println("\n and data is")
    game.printDataBoard()
    var x:Int
    var y: Int
    while(game.state !in GameFinished)
    {
        x=readln().toInt()
        y=readln().toInt()
        game.doMove(x,y)
        game.printBoard()
        game.printDataBoard()
    }

    println("\n left=${game.movesLeft}")

    game.switchMode()

     x=readln().toInt()
     y=readln().toInt()
       game.doMove(x,y)
    game.printBoard()
    println("\n and data is")

*/

    // println ("asd")
}