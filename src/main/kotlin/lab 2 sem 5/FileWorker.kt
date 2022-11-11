package `lab 2 sem 5`
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.w3c.dom.Node
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.parsers.DocumentBuilderFactory


class FileWorker(file: File) {

    private data class Floors(
        var first: Int = 0,
        var second: Int = 0,
        var third: Int = 0,
        var fourth: Int = 0,
        var fifth: Int = 0,
    )

    private var mapAddress = HashMap<Address, Int>()
    private var mapCity = HashMap<String, Floors>()

    init {
        when (file.toString().substring(file.toString().length - 3)) {
            "xml" -> xmlParser(file)
            "csv" -> csvParser(file)
        }
    }

    private fun csvParser(file: File) {
        val reader = Files.newBufferedReader(Paths.get(file.toString()))
        val csvParser = CSVParser(reader, CSVFormat.DEFAULT
            .withDelimiter(';')
            .withHeader("city", "street", "house", "floor")
            .withFirstRecordAsHeader()
            .withTrim())
        for (csvRecord in csvParser) {
            // Accessing Values by Column Index
            val city = csvRecord.get(0)
            val street = csvRecord.get(1)
            val house = csvRecord.get(2)
            val floor = csvRecord.get(3)
            val address = Address(city, street, house.toInt(), floor.toInt())
            if (mapAddress.containsKey(address)) {
                mapAddress.put(address, mapAddress.getValue(address) + 1)
            } else {

                mapAddress.put(address, 1)
            }


        }

        statistic()
    }

    private fun statistic() {
        mapAddress.forEach { entry ->
            if (entry.value > 1)
                println("${entry.key} repeats ${entry.value} times")
        }
        mapAddress.forEach { entry ->
            if (!mapCity.containsKey(entry.key.city))
                mapCity[entry.key.city] = Floors()
            when (entry.key.floor) {
                1 -> {
                    mapCity[entry.key.city]!!.first++
                }
                2 -> {
                    //mapCity.put(entry.key.city, Floors(mapCity[entry.key.city]!!.first, mapCity[entry.key.city]!!.second+1, mapCity[entry.key.city]!!.third, mapCity[entry.key.city]!!.fourth, mapCity[entry.key.city]!!.fifth))
                    mapCity[entry.key.city]!!.second++
                }
                3 -> {
                    mapCity[entry.key.city]!!.third++
                }
                4 -> {
                    mapCity[entry.key.city]!!.fourth++
                }
                5 -> {
                    mapCity[entry.key.city]!!.fifth++
                }
            }

        }
        mapCity.forEach { entry ->
            println("in ${entry.key} are: 1 floors:${entry.value.first}, 2 floors:${entry.value.second},3 floors:${entry.value.third},4 floors:${entry.value.fourth},5 floors:${entry.value.fifth}")
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

            val street = nodeList.item(i).attributes.getNamedItem("street").textContent

            val house = nodeList.item(i).attributes.getNamedItem("house").textContent.toInt()

            val floor = nodeList.item(i).attributes.getNamedItem("floor").textContent.toInt()

            val address = Address(city, street, house, floor)
            if (mapAddress.containsKey(address)) {
                mapAddress.put(address, mapAddress.getValue(address) + 1)

            } else {

                mapAddress.put(address, 1)
            }

            //  println(map)
        }




        statistic()
    }
}
