package lab3

import lab3.Contact.*

class ServiceFunctions : ContactsService {
    private val people: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addAddress(person: Person, address: Address) {
        people.getOrPut(person) { mutableListOf() }.add(address)
    }

    override fun addContact(person: Person, contact: Contact) {
        people.getOrPut(person) { mutableListOf() }.add(contact)
    }

    override fun addEmail(person: Person, mail: Email) {
        people.getOrPut(person) { mutableListOf() }.add(mail)
    }

    override fun addLink(person: Person, url: Url) {
        people.getOrPut(person) { mutableListOf() }.add(url)
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        people.getOrPut(person) { mutableListOf() }.add(Phone(phone, phoneType))
    }


    override fun getAllContacts(): Map<Person, List<Contact>> {
        return people
    }

    override fun getAllPersons(): List<Person> {
        //return buildList { people.forEach { it.key } }
        return people.keys.toList()
    }

    override fun getPersonEmails(person: Person): List<Email> {
        //return buildList { people[person]?.forEach{if(it is Email) this.add(it)} }
        return  people[person]?. filterIsInstance<Email>()!!.toList()
    }

    override fun getPersonLinks(person: Person): List<Url> {
        return  people[person]?. filterIsInstance<Url>()!!.toList()
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        return  people[person]?.toList()!!
    }

    override fun getPersonPhones(person: Person): List<Phone> {
        return  people[person]?. filterIsInstance<Phone>()!!.toList()
    }


    override fun removeAddress(person: Person,address: Address) {
/*        people[person]?.remove(Address)
        people[person]?.forEach { people[person]?.remove(Address) }*/
        people[person]?.remove(address)
    }

    override fun removeContact(person: Person, contact: Contact) {

    }


    override fun removeEmail(person: Person,email: Email) {
        // people[person]?.remove(Email)
        people[person]?.remove(email)
    }

    override fun removeLink(person: Person,url: Url) {
        people[person]?.remove(url)
    }

    override fun removePhone(person: Person,phone: Phone) {
        people[person]?.remove(phone)
    }

    override fun removePerson(person: Person) {
        people.remove(person)
    }


    override fun removeContacts(person: Person) {
        people.forEach { people.remove(person) }
    }

}


