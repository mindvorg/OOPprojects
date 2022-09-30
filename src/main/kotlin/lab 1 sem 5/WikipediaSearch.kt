package `lab 1 sem 5`
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.awt.Desktop
import java.net.URI
import java.net.URL
import java.net.URLEncoder

class WikipediaSearch(var requestString: String) {
    private val requestLink = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
    var wikipediaResults: MutableList<WikipediaPage>

    init {
        requestString = URLEncoder.encode(requestString, "UTF-8")
        var jsonResponse = URL(requestLink + requestString).readText();
        wikipediaResults = getResults(jsonResponse)
        if(wikipediaResults.isEmpty()) {
            throw Exception("Empty search result")
        }
    }

    private fun getResults(jsonString: String): MutableList<WikipediaPage> {
        var newResults: MutableList<WikipediaPage> = mutableListOf()

        val jsonArray = Gson()
            .fromJson(jsonString, JsonObject::class.java)
            .getAsJsonObject("query")//choose part after query
            .getAsJsonArray("search")//make array with parts after search(split in ,)
        jsonArray.forEach {
            newResults.add(WikipediaPage(it.asJsonObject.getAsJsonPrimitive("title").toString(), it.asJsonObject.getAsJsonPrimitive("pageid").toString() ))
        }

        return newResults
    }

    fun openLink(id: Int) {
        val u = URI("https://ru.wikipedia.org/w/index.php?curid=" +id)
        val d = Desktop.getDesktop()
        d.browse(u)
    }

}