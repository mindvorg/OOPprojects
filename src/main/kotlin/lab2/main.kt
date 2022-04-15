package lab2

fun main() {
    val listOfShapes = ShapeCollector()
    listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
    listOfShapes.add(Rectangle(Color(), Color(), 5.0, 4.0))
    listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
    listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
    println(listOfShapes.smallestArea())
    println(listOfShapes.sumOfAreas())
    println(listOfShapes.allShapes())
    println(listOfShapes.sortByName<Triangle>())
    println(listOfShapes.sortByBorderColor(Color()))
    println(listOfShapes.groupByFillColor())
}