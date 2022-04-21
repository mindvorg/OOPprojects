
package lab4

import java.io.File

enum class Cell(private val textValue: String) {
    A("a"),
    EMPTY(" "),
    WORM("~");

    override fun toString(): String = textValue
}

enum class State(val textValue: String) {
    WIN("U win")
}


private val lengthMap = 23
private val witdhMap = 73
private val firstPosition = Pair(22, 2)

open class PositionPerson()
{
    val xCord:Int= firstPosition.first
    val yCord:Int= firstPosition.second

}
class Model(): PositionPerson() {
    private var _map = readMap().toMutableMap()
    fun out() {
        for (i in 0 until lengthMap) {
            for (j in 0 until witdhMap) {
                print(_map[Pair(i, j)])
            }
            println()
        }
    }
    fun set(x:Int,y:Int,value: Char)
    {
        _map[Pair(x,y)]=value
    }

    fun doMove(x:Int,y:Int){
        require(x in 0 until lengthMap) { "Wrong row" }
        require(y in 0 until witdhMap) { "Wrong column" }
        if(checkWin(Pair(xCord,yCord))==1)
        {println("gg")} }

    private fun checkWin(pair: Pair<Int, Int>): Any {


    }
}

fun readMap(): Map<Pair<Int, Int>, Char> {
    val input = File("map.txt")
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val xCord = indexedValue.index
            indexedValue.value.toCharArray().withIndex().map { indexedChar ->
                val yCord = indexedChar.index
                (xCord to yCord) to indexedChar.value
            }
        }
        .toMap()
    return input

}