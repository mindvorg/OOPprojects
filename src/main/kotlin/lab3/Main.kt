package lab3

fun main() {
    val service = ServiceFunctions()
    val person1 = Person(firstName = "Ivan", secondName = "Ivanov")
    val data1 = Contact.Url("vk", "vk.com/paveldurov")
    val data2 = Contact.Email("asdpk@gmal.ru")
    val data3 = Contact.Phone("429748233294", PhoneType.Work)
    val data4=Contact.Address("Saint-P","Popova","54","0")
    service.addContact(person1, data1)
    service.addEmail(person1, data2)
    service.addContact(person1, Contact.Phone("429748233294", PhoneType.Work))
    service.addContact(person1, Contact.Phone("4297494", PhoneType.Mobile))
    service.addContact(person1, Contact.Phone("428294", PhoneType.Work))
    service.addAddress(person1,data4)
    val person2 = Person("Isaac", "Asimov")
    service.addContact(person2, data1)
    println(service.getAllContacts())
    println(service.getAllPersons())
    service.removeEmail(person1, data2)
    println(service.getPersonEmails(person1))
    println(service.getPersonLinks(person1))
    println("asd${service.getPersonContacts(person1)}")
    service.removePhone(person1, Contact.Phone("428294", PhoneType.Work))
    println("asdas${service.getPersonContacts(person1)}")
}