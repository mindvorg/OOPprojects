package lab5

fun main() {
    val fig1=Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0)
    val fig2=Rectangle(Color(), Color(), 5.0, 4.0)
    val fig3 = Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0)
    val fig4=Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0)
    val listOfShapes = ShapeCollector<ColoredShape2d>()
    listOfShapes.add(fig1)
    listOfShapes.add(fig2)
    val listOfShapes2 = ShapeCollector<ColoredShape2d>()
    listOfShapes2.add(fig3)
    listOfShapes2.add(fig4)
    listOfShapes.addAll(listOfShapes2.allShapes())
    println(listOfShapes.allShapes())
}