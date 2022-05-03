package lab6

fun main() {
    val listOfShapes = ShapeCollector()
    val fig1 = Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0)
    val fig2 = Rectangle(Color(), Color(), 5.0, 4.0)
    val fig3 = Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0)
    val fig4 = Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0)
    listOfShapes.add(fig1)
    listOfShapes.add(fig2)
    listOfShapes.add(fig3)
    listOfShapes.add(fig4)


    val test6 = SerializationAndDeserialization()
    val test6enc = test6.encodeJson(listOfShapes)
    println(test6enc)


    val url = "C:\\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\kotlin\\lab6\\testLab6.json"

    test6.writeJson(url, test6.encodeJson(listOfShapes))

    println("check that this is equal:${listOfShapes.allShapes() == test6.decodeJson(test6enc).allShapes()}")
}