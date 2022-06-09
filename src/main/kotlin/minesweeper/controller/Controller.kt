package minesweeper.controller

import minesweeper.GameFinished
import minesweeper.Model

class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state in GameFinished) {
            val input = readln()
            try {
                val col = input.substringBefore(" ").toInt() - 1
                val row = input.substringAfter(" ").toInt() - 1
                model.doMove(col, row)
            } catch (e: java.lang.Exception) {
                println(e.message)
            }
        }
    }
}