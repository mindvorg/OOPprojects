import lab2.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeCollectorTest {

    @Test
    fun add() {
        val listOfShapes = ShapeCollector().add(Circle(Color(), Color(), 5.0))
        assertEquals(ShapeCollector().add(Circle(Color(), Color(), 5.0)), listOfShapes)
    }

    @Test
    fun biggestArea() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        assertEquals(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0), listOfShapes.biggestArea())
    }

    @Test
    fun smallestArea() {

        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        assertEquals(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0), listOfShapes.smallestArea())

    }

    @Test
    fun summOfAreas() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        assertEquals(106.22354123346052, listOfShapes.summOfAreas())
    }


    @Test
    fun sortByBorderColor() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(), Color(), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        val expect = ShapeCollector()
        expect.add(Rectangle(Color(255, 255, 255, 100), Color(255, 255, 255, 100), 5.0, 4.0))
        assertEquals(expect.allShapes(), listOfShapes.sortByBorderColor(Color()))
    }


    @Test
    fun sortByFillColor() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(), Color(), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        val expect = ShapeCollector()
        expect.add(Rectangle(Color(255, 255, 255, 100), Color(255, 255, 255, 100), 5.0, 4.0))
        assertEquals(expect.allShapes(), listOfShapes.sortByFillColor(Color()))
    }

    @Test
    fun allShapes() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        val expect = listOf<ColoredShape2d>(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        assertEquals(expect, listOfShapes.allShapes())
    }

    @Test
    fun size() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(), Color(), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        assertEquals(4, listOfShapes.size())
    }

    /*        @Test
            fun groupByFillColor() { }

            @Test
            fun groupByBorderColor() {
            }*/
    @Test
    fun sortByName() {
        val listOfShapes = ShapeCollector()
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 5.0))
        listOfShapes.add(Rectangle(Color(), Color(), 5.0, 4.0))
        listOfShapes.add(Circle(Color(123, 55, 255, 50), Color(123, 55, 255, 50), 7.0))
        listOfShapes.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        val expect = ShapeCollector()
        expect.add(Triangle(Color(12, 12, 12), Color(213, 19, 255, 75), 5.0, 5.0, 5.0))
        assertEquals(expect.allShapes(), listOfShapes.sortByName<Triangle>())
    }
}