package lab3

fun main() {
    val service = ServiceFunctions()
    val person1 = Contact.Person(firstName = "Ivan", secondName = "Ivanov")
    val data1 = Contact.Url("vk", "vk.com/paveldurov")
    val data2 = Contact.Email("asdpk@gmal.ru")
    val data3 = Contact.Phone("429748233294", Contact.PhoneType.Work)
    service.addContact(person1, data1)
    service.addEmail(person1, data2)
    service.addContact(person1, Contact.Phone("429748233294", Contact.PhoneType.Work))
    service.addContact(person1, Contact.Phone("4297494", Contact.PhoneType.Mobile))
    service.addContact(person1, Contact.Phone("428294", Contact.PhoneType.Work))
    val person2 = Contact.Person("Isaac", "Asimov")
    service.addContact(person2, data1)
    println(service.getAllContacts())
    println(service.getAllPersons())
    service.removeEmail(person1, data2)
    println(service.getPersonEmails(person1))
    println(service.getPersonLinks(person1))
    println("asd${service.getPersonContacts(person1)}")
    service.removePhone(person1, Contact.Phone("428294", Contact.PhoneType.Work))
    println("asdas${service.getPersonContacts(person1)}")
}