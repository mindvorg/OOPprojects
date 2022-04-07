package lab2

fun main() {
    println("queres?")
    val listOfShapes = ShapeCollector()
    listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
    listOfShapes.add(Rectangle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0, 4.0))
    listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
    listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
    println(listOfShapes.smallestArea())
    println(listOfShapes.summOfAreas())
    println(listOfShapes.allShapes())
    println(listOfShapes.sortByName<Circle>())
}