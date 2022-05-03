package lab6

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

import java.io.File
import java.io.FileWriter
import java.io.IOException

private val json = Json {
    prettyPrint = true
    serializersModule = SerializersModule {
        polymorphic(ColoredShape2d::class) {
            subclass(Circle::class)
            subclass(Rectangle::class)
            subclass(Triangle::class)
            subclass(Square::class)
        }
    }
}

class SerializationAndDeserialization {
    fun encodeJson(input: ShapeCollector): String {
        return json.encodeToString(input)
    }

    fun decodeJson(output: String): ShapeCollector {
        return json.decodeFromString(output)
    }

    fun openJson(url: String): String {
        return File(url).readText()
    }

    fun writeJson(url: String, text: String) {
        File(url).printWriter().println(text)
        try {
            FileWriter(url).buffered().use { writer ->
                writer.write(text)
            }
        } catch (e: IOException) {
            // handle
        }
    }
}