package lab4
import java.io.File

enum class Cell(private val textValue: String) {
    A("a"),
    EMPTY(" "),
    WORM("~");

    override fun toString(): String = textValue
}

enum class State(val textValue: String) {
    WIN("U win"),
    NOTWIN("not win yet");

}


 val lengthMap = 23
 val witdhMap = 73
private val firstPosition = Pair(22, 2)
private val finishPosition = Pair(0, 70)

open class PositionPerson() {
    var xCord: Int = firstPosition.first
    var yCord: Int = firstPosition.second

}
interface ModelChangeListener {
    fun onModelChanged()
}

class Model() : PositionPerson() {
    private var _map = readMap().toMutableMap()
    var pos=Pair(xCord,yCord)
    var state: State = State.NOTWIN
        private set
    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    fun printout() {
        for (i in 0 until lengthMap) {
            for (j in 0 until witdhMap) {
                print(_map[Pair(i, j)])
            }
            println()
        }
    }



    fun doMove(x: Int, y: Int) {
        require(x in 0 until lengthMap) { "Wrong row" }
        require(y in 0 until witdhMap) { "Wrong column" }

        if (checkWin(pos.first,pos.second)) {
            println("gg")
            state=State.WIN
        } else {
            if (_map[Pair(x, y)] == ' ') {
                _map.set(Pair(xCord,yCord),' ')
                xCord = x
                yCord = y
                _map.set(Pair(xCord,yCord),'~')
            } else {
                error("u can't go here its wall")
            }
        }
        notifyListeners()
        printout()
    }
    fun set(x: Int, y: Int, value: Char) {
        _map[Pair(x, y)] = value
    }
    fun checkWin(x: Int, y: Int): Boolean {
        return Pair(x, y) == finishPosition
    }



private fun notifyListeners() {
    listeners.forEach { it.onModelChanged() }
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