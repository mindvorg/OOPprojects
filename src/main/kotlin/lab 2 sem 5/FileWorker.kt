package `lab 2 sem 5`

import org.w3c.dom.Node
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class FileWorker(file: File) {
    private var map = HashMap<Address, Int>()
    init {
        when   (file.toString().substring(file.toString().length-3))
        {
            "xml"-> xmlParser(file)
            "csv"-> csvParser()
        }
    }

    private fun csvParser() {
    println("drinking vodka playing dotka")
    }

    private fun xmlParser(file: File) {
         val builderFactory = DocumentBuilderFactory.newInstance()
         val docBuilder = builderFactory.newDocumentBuilder().parse(file)
         val nodeList = docBuilder.firstChild.childNodes
        for (i in 0 until nodeList.length) {
            if (nodeList.item(i).nodeType != Node.ELEMENT_NODE) {
                continue
            }
            val city = nodeList.item(i).attributes.getNamedItem("city").textContent
            print(city)
            val street = nodeList.item(i).attributes.getNamedItem("street").textContent
            print(" $street")
            val house = nodeList.item(i).attributes.getNamedItem("house").textContent.toInt()
            print(" $house")
            val floor = nodeList.item(i).attributes.getNamedItem("floor").textContent.toInt()
            print(" $floor")
            println()
            val address = Address(city, street, house, floor)
            if (map.containsKey(address)) {
                map.put(address,map.getValue(address)+1)
                println("S")
            } else {
                println("A")
               map.put(address,1)
            }
        }
        println(1)
    }
}