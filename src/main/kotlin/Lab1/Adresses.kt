package Lab1.Adresses

//Индекс1, Название города 1, ул. Название улицы, д. Номер дома
data class Addresses(val index: Int, val nameCity: String, val nameStreet: String, val house: Int) {}

fun parseAddresses(adresses: String): List<Addresses>? {
    if (adresses.isEmpty()) {
        return null
    }
    val listOfAddreses = mutableListOf<Addresses>()
    val splitString = adresses.split('\n')
//Splits this char sequence to a list of strings around occurrences of the specified delimiters. We do this to work with current string
    for (str in splitString) {
        val curStr = str.split(',')
        val index = curStr[0].substring(curStr[0].indexOf('.') + 1).toInt()//"."
        val city = curStr[1].substring(curStr[1].indexOf(", ") + 2)//", "
        val street = curStr[2].substring(curStr[2].indexOf(", ") + 5)//", ул. "
        val house = curStr[3].substring(curStr[3].indexOf(", ") + 4).toInt()//", д. "
        val address = Addresses(index, city, street, house)
        listOfAddreses.add(address)
    }
    return listOfAddreses
}

