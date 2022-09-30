package `lab 1 sem 5`

class WikipediaPage(var title: String,var pageid: String) {
    override fun toString(): String {
        return "title of page: $title, pageid: $pageid"
    }
}