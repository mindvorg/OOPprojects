package lab4
import java.io.File

/*
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa   a",
"a   a               a               a           a                   a   a",
"a   a   aaaaaaaaa   a   aaaaa   aaaaaaaaa   aaaaa   aaaaa   aaaaa   a   a",
"a               a       a   a           a           a   a   a       a   a",
"aaaaaaaaa   a   aaaaaaaaa   aaaaaaaaa   aaaaa   a   a   a   aaaaaaaaa   a",
"a       a   a               a           a   a   a   a   a           a   a",
"a   a   aaaaaaaaaaaaa   a   a   aaaaaaaaa   aaaaa   a   aaaaaaaaa   a   a",
"a   a               a   a   a       a           a           a       a   a",
"a   aaaaaaaaaaaaa   aaaaa   aaaaa   a   aaaaa   aaaaaaaaa   a   aaaaa   a",
"a           a       a   a       a   a       a           a   a           a",
"a   aaaaa   aaaaa   a   aaaaa   a   aaaaaaaaa   a   a   a   aaaaaaaaaaaaa",
"a       a       a   a   a       a       a       a   a   a       a       a",
"aaaaaaaaaaaaa   a   a   a   aaaaaaaaa   a   aaaaa   a   aaaaa   aaaaa   a",
"a           a   a           a       a   a       a   a       a           a",
"a   aaaaa   a   aaaaaaaaa   aaaaa   a   aaaaa   aaaaa   aaaaaaaaaaaaa   a",
"a   a       a           a           a       a   a   a               a   a",
"a   a   aaaaaaaaa   a   aaaaa   aaaaaaaaa   a   a   aaaaaaaaaaaaa   a   a",
"a   a           a   a   a   a   a           a               a   a       a",
"a   aaaaaaaaa   a   a   a   aaaaa   aaaaaaaaa   aaaaaaaaa   a   aaaaaaaaa",
"a   a       a   a   a           a           a   a       a               a",
"a   a   aaaaa   aaaaa   aaaaa   aaaaaaaaa   aaaaa   a   aaaaaaaaa   a   a",
"a   a                   a           a               a               a   a",
"a   aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
*/
fun main(){
    println("queres lab 4?")
val input= readInput().toMutableMap()
println(input)
    println("as=${input[Pair(0,0)]}")
    input[Pair(0,0)]='2'
    println("as=${input[Pair(0,0)]}")
    println(input)

    val test=Model()
    //test.out()
    //test[Pair(23,2)]='F'
    test._map[Pair(22,0)]='F'
    test.out()
}

fun readInput():Map<Pair<Int,Int>,Char> {
    val input = File("map.txt")
        .readLines()
        .withIndex()
        .flatMap {indexedValue->
            val xCord = indexedValue.index
            indexedValue.value.toCharArray().withIndex().map { indexedChar ->
                val yCord = indexedChar.index
                (xCord to yCord) to indexedChar.value
            }
        }
        .toMap()
return input

}