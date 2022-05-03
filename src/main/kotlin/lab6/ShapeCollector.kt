package lab6

import kotlinx.serialization.Serializable

@Serializable
class ShapeCollector {
    private val listOfShapes = mutableListOf<ColoredShape2d>()
    fun add(shape: ColoredShape2d) {
        listOfShapes.add(shape)
    }

    fun biggestArea(): ColoredShape2d? {
        return listOfShapes.maxByOrNull { it.calcArea() }
    }

    fun smallestArea(): ColoredShape2d? {
        return listOfShapes.minByOrNull { it.calcArea() }
    }

    fun sumOfAreas(): Double {
        return listOfShapes.sumOf { it.calcArea() }
    }

    fun sortByBorderColor(color: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.borderColor == color }
    }

    fun sortByFillColor(color: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.fillColor == color }
    }

    fun allShapes(): List<ColoredShape2d> {
        return listOfShapes
    }

    fun size(): Int {
        return listOfShapes.size
    }

    fun groupByFillColor(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    fun groupByBorderColor(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    inline fun <reified T> sortByName(): List<ColoredShape2d> {
        return this.allShapes().filter { it is T }
    }
}
