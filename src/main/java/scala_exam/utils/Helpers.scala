package scala_exam.utils

import scala_exam.models.{Client, Person, Request, User}

import scala.collection.mutable.ListBuffer

object Helpers {
  implicit class StringHelper(string: String) {
    def getClient(delimiter: String): Client = {
      val csvString: Array[String] = string.split(delimiter)
      Client(csvString(0).trim,
        csvString(1).trim,
        csvString(2).trim,
        Integer.parseInt(csvString(3).trim),
        csvString(4).trim,
        csvString(5).trim,
        csvString(6).trim,
        csvString(7).trim,
        Integer.parseInt(csvString(8).trim),
        csvString(9).trim,
        Integer.parseInt(csvString(10).trim))
    }

    def getPerson(delimiter: String): Person = {
      val csvString: Array[String] = string.split(delimiter)
      Person(Integer.parseInt(csvString(0).trim),
        csvString(1).trim,
        csvString(2).trim,
        csvString(3).trim,
        csvString(4).trim,
        csvString(5).trim,
        csvString(6).trim)
    }

    def getRequest(delimiter: String): Request = {
      val csvString: Array[String] = string.split(delimiter)
      Request(Integer.parseInt(csvString(0).trim),
        Integer.parseInt(csvString(1).trim),
        csvString(2).trim,
        csvString(3).trim,
        csvString(4).trim,
        Integer.parseInt(csvString(5).trim))
    }

    def isValidPhoneNumber(): Boolean = {
      val allowedChars: String="-0123456789"
      string.distinct.forall(c => allowedChars.contains(c))
    }

    def isValidEmail(): Boolean = string.contains("@") && string.contains(".com")
  }

  implicit class IntHelper(number: Int) {
    def isNaturalNumber(): Boolean = number > 0
    def isBetween(min: Int, max: Int): Boolean = number >= min && number <= max
  }

  implicit class ClientValidator(client: Client) {
    def hasValidPhoneAndEmail: Boolean = client.phone.isValidPhoneNumber() &&
                                                client.email.isValidEmail()

    def hasValidAge: Boolean = client.age.isNaturalNumber()
  }

  implicit class PersonValidor(person: Person) {
    def hasValidPhoneAndEmail: Boolean = person.phone.isValidPhoneNumber() &&
                                                person.email.isValidEmail()

    def hasValidAge: Boolean = person.age.isNaturalNumber()
  }

  implicit class ClientListHelper (clientList: List[Client]) {
    def toUsersList: ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      clientList.map(client => usersList += client)
      usersList
    }
  }

  implicit class PersonListHelper (personList: List[Person]){
    def toUsersList(): ListBuffer[User] = {
      var usersList: ListBuffer[User] = new ListBuffer[User]()
      personList.map(person => usersList += person)
      usersList
    }
  }
}
