package lab3

enum class PhoneType { Mobile, Work, Home }
data class Person(val firstName: String, val secondName: String)
sealed class Contact() {

    data class Phone(val number: String?, val type: PhoneType) : Contact() //mobile phone has 11 numbers, city phone-8
    data class Email(val mail: String?) : Contact()
    data class Address(val city: String?, val street: String?, val house: String?, val floor: String?) : Contact()
    data class Url(val name: String?, val url: String?) : Contact()

}
