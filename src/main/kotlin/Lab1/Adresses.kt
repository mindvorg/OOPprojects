package Lab1.Adresses


data class Addresses(val index: Int, val nameCity: String, val nameStreet: String, val house: Int) {}

fun parseAddresses(addresses: String): List<Addresses>? {
    if (addresses.isEmpty()) {
        return null
    }
    val listOfAddreses = mutableListOf<Addresses>()
    val splitString = addresses.split('\n')
//Splits this char sequence to a list of strings around occurrences of the specified delimiters. We do this to work with current string
    for (str in splitString) {
        val curStr = str.split(',')
        //Индекс1, Название города 1, ул. Название улицы, д. Номер дома
        val index = curStr[0].substring(curStr[0].indexOf('.') + 1).toInt()//"."
        val city = curStr[1].substring(curStr[1].indexOf(", ") + 2)//", "
        val street = curStr[2].substring(curStr[2].indexOf(", ") + 6)//", ул. "
        val house = curStr[3].substring(curStr[3].indexOf(", ") + 4).toInt()//", д. "
        val curAddress = Addresses(index, city, street, house)
        listOfAddreses.add(curAddress)
    }
    return listOfAddreses
}

fun biggestIndex(addresses: List<Addresses>): Addresses? = addresses.maxByOrNull { it.index }

fun smallestIndex(addresses: List<Addresses>): Addresses? = addresses.minByOrNull { it.index }

fun biggestStreet(addresses: List<Addresses>): Addresses? = addresses.maxByOrNull { it.nameStreet.length }

fun smallestStreet(addresses: List<Addresses>): Addresses? = addresses.minByOrNull { it.nameStreet.length }

