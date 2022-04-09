package lab2

import kotlin.math.PI
import kotlin.math.sqrt

data class Color(val red: Int = 255, val green: Int = 255, val blue: Int = 255, val visibility: Int = 100)

interface Shape2d {
    fun calcArea(): Double

}

interface ColoredShape2d : Shape2d {
    val borderColor: Color
    val fillColor: Color
}

data class Circle(override val borderColor: Color, override val fillColor: Color, var radius: Double) :
    ColoredShape2d {
    override fun calcArea(): Double {
        if (radius <= 0) error("radius can not be less 0")
        else {
            return PI * radius*radius
        }
    }
}

data class Rectangle(override val fillColor: Color, override val borderColor: Color, val a: Double, val b: Double) :
    ColoredShape2d {
    override fun calcArea(): Double {
        if (a <= 0 || b <= 0) error("side can not be less 0")
        else {
            return a * b
        }
    }
}

data class Square(override val fillColor: Color, override val borderColor: Color, val a: Double, val b: Double) :
    ColoredShape2d {
    override fun calcArea(): Double {
        if (a <= 0) error("side can not be less 0")
        else {
            return a * a
        }
    }
}

data class Triangle(
    override val borderColor: Color, override val fillColor: Color, val a: Double, val b: Double, val c: Double,
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (a <= 0 || b <= 0 || c <= 0 || a > b + c || b > a + c || c > a + b) {
            error("side can not be less 0")
        } else
            return sqrt((((a + b + c) / 2) - c) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - a) * ((a + b + c) / 2))
    }
}