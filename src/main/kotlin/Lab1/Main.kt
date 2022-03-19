package Lab1

import Lab1.Adresses.*

fun main() {
    val addresses2=""
    val addresses = "1.754291, Санкт-Петербург, ул. Космонавтов, д.47\n" +
            "2.563084, Москва, ул. Ленина, д.13\n" +
            "3.687424, Киров, ул. Энгельса, д.64\n" +
            "4.194192, Анапа, ул. Типанова, д.27\n" +
            "5.532212, Ставрополь, ул. Киевская,\tд.64\n" +
            "6.128925, Уфа, ул. Херсонская, д.63\n" +
            "7.576277, Москва, ул. Громова, д.88\n" +
            "8.100785, Минск, ул. Дивенская, д.88\n" +
            "9.304883, Мурманск, ул. Съезжинская, д.86\n" +
            "10.976672, Птерозаводск, ул. Труда, д.84\n" +
            "11.773348, Санкт-Петеребург, ул. Глинка, д.19\n" +
            "12.728544, Белгород, ул. Шкапина, д.51\n" +
            "13.176478, Калининград, ул. Звездная, д.84\n" +
            "14.440636, Москва, ул. Ленина, д.73\n" +
            "15.383197, Москва, ул. Алтайская, д.2\n" +
            "16.706150, Санкт-Петербург, ул. Громова, д.16\n" +
            "17.637562, Минск, ул. Космонавтов, д.64\n" +
            "18.795466, Уфа, ул. Типанова, д.37\n" +
            "19.169130, Владивосток, ул. Шевцова, д.29\n" +
            "20.240555, Киров, ул. Кировская, д.53".trimIndent()
    val listOfAddresses: List<Addresses>? = parseAddresses(addresses)
    if(listOfAddresses!=null){
    if (biggestIndex(listOfAddresses) != null)
    {
        println("the biggest index is:${biggestIndex(listOfAddresses)}")}
    if (smallestIndex(listOfAddresses) != null)
    {
        println("the smallest index is:${smallestIndex(listOfAddresses)}")}

    if (biggestStreet(listOfAddresses) != null)
    {
        println("the biggest street is:${biggestStreet(listOfAddresses)}")}
    if (smallestStreet(listOfAddresses) != null)
    {
        println("the smallest street is:${smallestStreet(listOfAddresses)}")}
}
else
    {
        println("null list")}
}