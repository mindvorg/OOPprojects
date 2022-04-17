package lab3


import lab3.Contact.*

interface ContactsService {
    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: Phone)
    fun addEmail(person: Person, mail: Email)
    fun addLink(person: Person, url: Url)
    fun addAddress(person: Person, address: Address)

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Phone>
    fun getEmails(person: Person):List<Email>
    fun getLinks(person: Person):List<Person>

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    // find
    fun removeContacts(person: Person)
    fun removePhone(person: Person)
    fun removeEmail(person: Person)
    fun removeAddress(person: Person)
    fun removeLink(person: Person)
}


