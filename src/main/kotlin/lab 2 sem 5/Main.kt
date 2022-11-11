package `lab 2 sem 5`

import java.io.File


fun main() {
    println("Enter request phrase:")

    //"C:\\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\testXML.xml"
    //"C:\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\testCSV.csv"
    var file = File(readln())
    while(file.toString()!="exit") {
        try {
            val begin = System.nanoTime()
            FileWorker(file)
            val end = System.nanoTime()
            println("u lose time: ${(end - begin) / 1000000000}")
        } catch (e: Exception) {
            println("wrong file name")
        }
        file = File(readln())
    }

}
