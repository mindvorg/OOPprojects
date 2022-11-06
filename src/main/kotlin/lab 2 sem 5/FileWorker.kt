package `lab 2 sem 5`

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.w3c.dom.Node
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.parsers.DocumentBuilderFactory

class FileWorker(file: File) {
    private var map = HashMap<Address, Int>()
    init {
        when   (file.toString().substring(file.toString().length-3))
        {
            "xml"-> xmlParser(file)
            "csv"-> csvParser(file)
        }
    }

    private fun csvParser(file: File) {
    println("drinking vodka playing dotka")
        val reader = Files.newBufferedReader(Paths.get(file.toString()))
        val csvParser = CSVParser(reader, CSVFormat.DEFAULT
            .withDelimiter(';')
            .withHeader("city", "street", "house","floor")
            .withFirstRecordAsHeader()
            .withTrim())
        for (csvRecord in csvParser) {
            // Accessing Values by Column Index
            val city = csvRecord.get(0)
            val street =  csvRecord.get(1)
            val house = csvRecord.get(2)
            val floor = csvRecord.get(3)
            println("---------------")
            println("Name : $city")
            println("Product : $street")
            println("Description : $house")
            println("Description : $floor")
            println("--------------- ")
            if (map.containsKey(Address(city, street, house.toInt(), floor.toInt()))) {
                map.put(Address(city, street, house.toInt(), floor.toInt()),map.getValue(Address(city, street, house.toInt(), floor.toInt()))+1)
                println("S")
            } else {
                println("A")
                map.put(Address(city, street, house.toInt(), floor.toInt()),1)
            }
        }
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

    }
}