package lab2

class ShapeCollector<T : ColoredShape2d>  {
    private var listOfShapes = mutableListOf<T>()
    fun add(shape:  T) {
        listOfShapes.add(shape)

    }

    fun biggestArea(): T? {
        return listOfShapes.maxByOrNull { it.calcArea() }
    }

    fun smallestArea(): T? {
        return listOfShapes.minByOrNull { it.calcArea() }
    }

    fun sumOfAreas(): Double {
        return listOfShapes.sumOf { it.calcArea() }
    }

    fun sortByBorderColor(color: Color): List<T> {
        return listOfShapes.filter { it.borderColor == color }
    }

    fun sortByFillColor(color: Color): List<T> {
        return listOfShapes.filter { it.fillColor == color }
    }

    fun allShapes(): List<T> {
        return listOfShapes
    }

    fun size(): Int {
        return listOfShapes.size
    }

    fun groupByFillColor(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    fun groupByBorderColor(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    inline fun <reified T> sortByName(): List<ColoredShape2d> {
        return this.allShapes().filter { it is T }
    }

    fun addAll(list: List< T>) {
        listOfShapes += list
    }


    fun getSorted(comparator: Comparator<in  T>): List<T> {
        return listOfShapes.sortedWith(comparator)
    }
}
