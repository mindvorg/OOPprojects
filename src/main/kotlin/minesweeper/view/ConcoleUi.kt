package minesweeper.view

import minesweeper.Model
import minesweeper.ModelChangeListener

class ConcoleUi(private val model: Model) {

    init {
        val listener=object :ModelChangeListener{
            override fun onModelChanged() {
                repaint()
            }
        }
        model.addModelChangeListener(listener)
    }

    private fun repaint() {
    model.printBoard()
    }
}