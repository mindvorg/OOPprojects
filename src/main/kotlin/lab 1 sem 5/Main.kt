package `lab 1 sem 5`


fun main() {
    println("Enter request phrase:")
    val userSearch = readln()

    try {
        val searchResult = WikipediaSearch(userSearch)

        searchResult.wikipediaResults.forEach {
            println(it)
        }

        println("Choose page ID to open")
        val id = readln().toInt()

        searchResult.openLink(id)
    } catch (e: java.lang.Exception) {
        println(e.message)
    } catch (e: java.lang.NumberFormatException) {
        println("Enter a number!")
    } catch (e: java.lang.IndexOutOfBoundsException) {
        println("Enter a valid page ID!")
    }
}