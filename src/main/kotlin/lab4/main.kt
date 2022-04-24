package lab4

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
/*val input= readInput().toMutableMap()
println(input)
    println("as=${input[Pair(0,0)]}")
    input[Pair(0,0)]='2'
    println("as=${input[Pair(0,0)]}")
    println(input)*/

    val test=Model()
 /*   test.set(22,2,'~')*/
/*    test.printout()

    test.printout()
    println("1")
    test.set(0,70,'@')
    test.printout()
    println("2")
    test.doMove(21,2)
    println("3")
    test.printout()
    println("4")
    test.doMove(21,3)
    println("5")
    test.printout()
  *//*  test.doMove(21,4)
    println()                       it's throw error and it's ok
    test.printout()*//*
    test.doMove(22,3)
    println()
    test.printout()
    test.doMove(21,3)
    println()
    test.printout()
    println()
    println()
    println()
    println()*/
/*    SwingUtilities.invokeLater {
        val mazeui=
    }*/


    println("start\n\n\n")
/*    while(!test.checkWin(test.pos.first,test.pos.second)) {
        val maze = Controller(test)
        println("x=${test.pos.first} y=${test.pos.second}")
        println("x=${test.xCord} y=${test.yCord}")
    }*/
   Controller(test)
  /*  var x=0
    var y=0
    val input = readln().toCharArray()
    println("11111111111=$input")

    val whn= input[0].toInt()
    println("11111111111=$whn")
*/

}

/*
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

}*/