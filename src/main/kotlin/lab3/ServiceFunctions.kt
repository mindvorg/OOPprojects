package lab3

import lab3.Contact.*

class ServiceFunctions(val contactsService: ContactsService) : ContactsService {
    val people: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addAddress(person: Person, address: Contact.Address) {
        people[person]?.add(address)
    }

    override fun addContact(person: Person, contact: Contact) {
        people[person]?.add(contact)
    }

    override fun addEmail(person: Person, mail: Email) {
        people[person]?.add(mail)
    }

    override fun addLink(person: Person, url: Url) {
        people[person]?.add(url)
    }

    override fun addPhone(person: Person, phone: Phone, phoneType: Phone) {
        people[person]?.add(phone)
        if (phone.toString().length==11) {phoneType="mobile" people[person]?.add(phoneType)}
    }



    override fun getAllContacts(): Map<Person, List<Contact>> {

    }

    override fun getAllPersons(): List<Person> {

    }

    override fun getEmails(person: Person): List<Email> {

    }

    override fun getLinks(person: Person): List<Person> {

    }

    override fun getPersonContacts(person: Person): List<Contact> {

    }

    override fun getPersonPhones(person: Person): List<Phone> {

    }

    override fun removeAddress(person: Person) {

    }

    override fun removeContact(person: Person, contact: Contact) {

    }

    override fun removeContacts(person: Person) {

    }

    override fun removeEmail(person: Person) {

    }

    override fun removeLink(person: Person) {

    }

    override fun removePerson(person: Person) {

    }

    override fun removePhone(person: Person) {

    }


}