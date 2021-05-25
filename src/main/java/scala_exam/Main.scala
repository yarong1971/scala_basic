package scala_exam

import scala_exam.models.User
import scala_exam.utils.Helpers.{ClientListHelper, ClientValidator, PersonListHelper, PersonValidor, StringHelper}

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {

    /*val mapper = new ObjectMapper()
    val input = new FileInputStream("data/persons.json")
    val personsArr = mapper.readValue(input, classOf[Array[Person]])
*/
    //val jsonHelper = JsonHelper
    //val request =  jsonHelper.getRequest("data/request.json")
    //println(request)

    var usersList = new ListBuffer[User]()

    val clientsCSV = Source.fromFile("data/client.csv").getLines.toList
    val personsCSV = Source.fromFile("data/persons.csv").getLines.toList
    val requestCSV = Source.fromFile("data/request.csv").getLines.toList

    val clients = clientsCSV.map(client => client.getClient(","))
    val persons = personsCSV.map(person => person.getPerson(","))
    val request = requestCSV.map(request => request.getRequest(","))

    val validClients = clients.filter(client => client.hasValidPhoneAndEmail)
      .filter((client => client.hasValidAge))

    val validPersons = persons.filter(person => person.hasValidPhoneAndEmail)
      .filter(person => person.hasValidAge)

    usersList = clients.toUsersList
    usersList.addAll(persons.toUsersList())

    println(usersList.size)

    val filteredUsersList = usersList.filter(user => user.filterByRequest(request(0)))

    filteredUsersList.foreach(user => println(user))
  }
}
