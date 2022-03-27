import lab1.Addresses
import lab1.parseAddresses
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

internal class AdressesKtTest {

    @Test
    fun parseAddresses() {
        val addresses = """
            1.754291, Санкт-Петербург, ул. Космонавтов, д.47
            2.563084, Москва, ул. Ленина, д.13
            3.687424, Киров, ул. Энгельса, д.64
           """.trimIndent()
        val listofAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        val alsoListOfAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        assertNotNull(parseAddresses(addresses))
        assertEquals(listofAddresses, alsoListOfAddresses)
    }

    @Test
    fun biggestIndex() {
        val listofAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        assertEquals(lab1.biggestIndex(listofAddresses), listofAddresses[0])
        assertEquals(lab1.biggestIndex(emptyList()), null)
    }

    @Test
    fun smallestIndex() {
        val listofAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        assertEquals(lab1.smallestIndex(listofAddresses), listofAddresses[1])
        assertEquals(lab1.smallestIndex(emptyList()), null)
    }

    @Test
    fun biggestStreet() {
        val listofAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)
        )
        assertEquals(lab1.biggestStreet(listofAddresses), listofAddresses[0])
        assertEquals(lab1.biggestStreet(emptyList()), null)
    }

    @Test
    fun smallestStreet() {
        val listofAddresses: List<Addresses> = listOf(
            Addresses(754291, "Санкт-Петербург", "Космонавтов", 47),
            Addresses(563084, "Москва", "Ленина", 13),
            Addresses(687424, "Киров", "Энгельса", 64)

        )
        assertEquals(lab1.smallestStreet(listofAddresses), listofAddresses[1])
        assertEquals(lab1.smallestStreet(emptyList()), null)
    }
}