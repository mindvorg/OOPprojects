package lab4
class Controller(private val model: Model) {
    init {
        model.printout()
        startGame()
    }

    private fun startGame() {
        var x=0
        var y=0
            val input = readln().toCharArray()
           val whn= input[0].toInt()
            try {
                when (whn) {
                    /*         val x = input.substringBefore(" ").toInt() - 1
                val y = input.substringAfter(" ").toInt() - 1*/
                    119 -> {//w=119
                        x = model.pos.first-1
                        y = model.pos.second
                    }
                    97->{//a=97
                        x = model.pos.first
                        y = model.pos.second-1
                    }
                    115->{//s=115
                        x = model.pos.first + 1
                        y = model.pos.second
                    }
                    100->{//d=100
                        x = model.pos.first
                        y = model.pos.second+1
                    }
                }
                model.doMove(x, y)
            } catch (e: Exception) {
                println(e.message)
            }

    }
}