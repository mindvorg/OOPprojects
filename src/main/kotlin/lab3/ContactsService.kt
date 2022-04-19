package lab3


import lab3.Contact.*

interface ContactsService {
    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)
    fun addPhone(person: Person, phone: String,phoneType: PhoneType)
    fun addEmail(person: Person, mail: Email)
    fun addLink(person: Person, url: Url)
    fun addAddress(person: Person, address: Address)

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Phone>
    fun getPersonEmails(person: Person):List<Email>
    fun getPersonLinks(person: Person):List<Url>

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    // find
    fun removeContacts(person: Person)
    fun removePhone(person: Person,phone: Phone)
    fun removeEmail(person: Person,email: Email)
    fun removeAddress(person: Person,address: Address)
    fun removeLink(person: Person,url: Url)
}


