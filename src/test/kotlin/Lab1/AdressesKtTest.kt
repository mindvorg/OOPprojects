import Lab1.Addresses
import Lab1.parseAddresses
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import kotlin.test.assertNull


internal class AdressesKtTest {

    @Test
    fun parseAddresses() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses = parseAddresses(addresses)
        val nullAdresses = ""

        val alsoListOfAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        assertNotNull(parseAddresses(addresses))
        assertNull(parseAddresses(nullAdresses))
        assertEquals(listofAddresses, alsoListOfAddresses)
    }

    @Test
    fun biggestIndex() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses = parseAddresses(addresses)
        assertEquals(Lab1.biggestIndex(listofAddresses!!), listofAddresses[0])
        assertEquals(Lab1.biggestIndex(emptyList()), null)
    }

    @Test
    fun smallestIndex() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses = parseAddresses(addresses)
        assertEquals(Lab1.smallestIndex(listofAddresses!!), listofAddresses[1])
        assertEquals(Lab1.smallestIndex(emptyList()), null)
    }

    @Test
    fun biggestStreet() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses = parseAddresses(addresses)
        assertEquals(Lab1.biggestStreet(listofAddresses!!), listofAddresses[0])
        assertEquals(Lab1.biggestStreet(emptyList()), null)
    }

    @Test
    fun smallestStreet() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses = parseAddresses(addresses)
        assertEquals(Lab1.smallestStreet(listofAddresses!!), listofAddresses[1])
        assertEquals(Lab1.smallestStreet(emptyList()), null)
    }
}