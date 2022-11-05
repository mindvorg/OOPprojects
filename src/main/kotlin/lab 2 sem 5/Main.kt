package `lab 2 sem 5`

import java.io.File


fun main() {
    println("Enter request phrase:")

    //"C:\\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\testXML.xml"
    //"C:\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\testCSV.csv"
    val file = File(readln())
    try {
        val begin = System.nanoTime()
        FileWorker(file)
        val end = System.nanoTime()
        println("u lose time: ${(end-begin)/ 1000000000}")
    } catch (e: Exception) {
        println("wrong file name")
    }
//    var map = HashMap<String, Int>()
//    for (i in 0..5)
//    {
//        val tmp=readln()
//        if(map.containsKey(tmp))
//        {
//            map.put(tmp,map.getValue(tmp)+1)
//            println("a")
//        }
//        else{
//            map.put(tmp,1)
//            println("s")
//        }
//
//    }



}