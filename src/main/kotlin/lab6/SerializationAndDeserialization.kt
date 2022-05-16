package lab6
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab2.*
import java.io.File
import java.io.FileWriter

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
    fun encodeJson(input: List<ColoredShape2d>): String {
        return json.encodeToString(input)
    }

    fun readFile(url: String): String {
        return File(url).readText()
    }

    fun decodeJson(output: String):  List<ColoredShape2d> {
        return json.decodeFromString(output)
    }

    fun writeJson(url: String, text: String) {
            FileWriter(url).buffered().use { writer ->
                writer.write(text)
            }
    }
}
