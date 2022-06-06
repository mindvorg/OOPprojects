package minesweeper

import minesweeper.view.MineSweeperUI
import javax.swing.SwingUtilities

fun main()
{
    SwingUtilities.invokeLater{
        val mineSweeperUI=MineSweeperUI()
        mineSweeperUI.isVisible=true
    }
    println ("asd")
}