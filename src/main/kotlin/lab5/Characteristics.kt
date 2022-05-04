package lab5

import kotlin.math.PI
import kotlin.math.sqrt

data class Color(val red: Int = 255, val green: Int = 255, val blue: Int = 255, val visibility: Int = 100) {init {
    require(red in 0..255) { "wrong value of the red color" }
    require(green in 0..255) { "wrong value of the red color" }
    require(blue in 0..255) { "wrong value of the red color" }
    require(visibility in 0..100) { "wrong value of the red color" }
}
}

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
        return PI * radius * radius
    }

    init {
        if (radius <= 0) error("radius can not be less 0")
    }
}

data class Rectangle(override val fillColor: Color, override val borderColor: Color, val a: Double, val b: Double) :
    ColoredShape2d {
    override fun calcArea(): Double {
        return a * b
    }

    init {
        if (a <= 0 || b <= 0) error("side can not be less 0")
    }
}

data class Square(override val fillColor: Color, override val borderColor: Color, val a: Double, val b: Double) :
    ColoredShape2d {
    override fun calcArea(): Double {
        return a * a
    }

    init {
        if (a <= 0) error("side can not be less 0")
    }
}


data class Triangle(
    override val borderColor: Color, override val fillColor: Color, val a: Double, val b: Double, val c: Double,
) : ColoredShape2d {
    override fun calcArea(): Double {
        return sqrt((((a + b + c) / 2) - c) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - a) * ((a + b + c) / 2))
    }

    init {
        if (a <= 0 || b <= 0 || c <= 0 || a > b + c || b > a + c || c > a + b) {
            error("side can not be less 0")
        }
    }
}