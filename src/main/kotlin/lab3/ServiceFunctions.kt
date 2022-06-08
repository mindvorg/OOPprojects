package lab3

import lab3.Contact.*
import org.apache.logging.log4j.LogManager

private val LOG = LogManager.getLogger(ServiceFunctions::class.java)

class ServiceFunctions : ContactsService {

    private val people: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addAddress(person: Person, address: Address) {
        people.getOrPut(person) { mutableListOf() }.add(address)
        LOG.info("added address $address to $person")
    }

    override fun addContact(person: Person, contact: Contact) {
        people.getOrPut(person) { mutableListOf() }.add(contact)
        LOG.info("added contact $contact to $person")
    }

    override fun addEmail(person: Person, mail: Email) {
        people.getOrPut(person) { mutableListOf() }.add(mail)
        LOG.info("added mail $mail to $person")
    }

    override fun addLink(person: Person, url: Url) {
        people.getOrPut(person) { mutableListOf() }.add(url)
        LOG.info("added url $url to $person")
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        people.getOrPut(person) { mutableListOf() }.add(Phone(phone, phoneType))
        LOG.info("added phone $phone with phone type$phoneType to $person")
    }


    override fun getAllContacts(): Map<Person, List<Contact>> {
        return people
        LOG.info("get all contacts")
    }

    override fun findPerson(firstName: String, secondName: String): List<Person> {
        return people.keys.filter { firstName in it.firstName && secondName in it.secondName }
        LOG.info("find person with $firstName $secondName")
    }

    override fun getAllPersons(): List<Person> {
        return people.keys.toList()
        LOG.info("get all persons ")

    }

    override fun getPersonEmails(person: Person): List<Email> {
        return people[person]?.filterIsInstance<Email>()?.toList() ?: emptyList()
        LOG.info("get emails of $person")
    }

    override fun getPersonLinks(person: Person): List<Url> {
        return people[person]?.filterIsInstance<Url>()?.toList() ?: emptyList()
        LOG.info("get links of $person")
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        return people[person]?.toList() ?: emptyList()
        LOG.info("get contacts of $person")
    }

    override fun getPersonPhones(person: Person): List<Phone> {
        return people[person]?.filterIsInstance<Phone>()?.toList() ?: emptyList()
        LOG.info("get phones of $person")
    }


    override fun removeAddress(person: Person, address: Address) {
        people[person]?.remove(address)
        LOG.info("remove $address from $person")
    }

    override fun removeContact(person: Person, contact: Contact) {

    }


    override fun removeEmail(person: Person, email: Email) {

        people[person]?.remove(email)
        LOG.info("remove $email from $person")
    }

    override fun removeLink(person: Person, url: Url) {
        people[person]?.remove(url)
        LOG.info("remove $url from $person")
    }

    override fun removePhone(person: Person, phone: Phone) {
        people[person]?.remove(phone)
        LOG.info("remove $phone from $person")
    }

    override fun removePerson(person: Person) {
        people.remove(person)
        LOG.info("remove  $person")
    }


    override fun removeContacts(person: Person) {
        if (people.contains(person)) {
            people[person]?.clear()
            LOG.info("remove contacts for $person")
        } else {
            LOG.info("nothing to remove in contacts to $person")
        }
    }

}


