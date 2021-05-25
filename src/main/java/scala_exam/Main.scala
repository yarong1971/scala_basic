package scala_exam

import scala_exam.models.User
import scala_exam.utils.{ExcelHandler, JsonHandler}
import scala_exam.utils.Helpers.{ClientHelper, ClientListHelper, PersonListHelper, PersonValidor, StringHelper}

import java.util.Properties
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    //val url = getClass.getResource("src/main/resources/application.properties")
    //val properties: Properties = new Properties()

    val filesDirectory = "data/"//properties.getProperty("files_dir")
    val clientsFile = filesDirectory + "client.xlsx" //properties.getProperty("clients_file")
    val personsFile = filesDirectory + "persons.json" //properties.getProperty("persons_file")
    val requestFile = filesDirectory + "request.json" //properties.getProperty("request_file")

    val jsonHelper = JsonHandler
    val excelHelper = ExcelHandler

    val clients = excelHelper.read(clientsFile) //("data/client.xlsx")
    val persons = jsonHelper.getPersons(personsFile) //("data/persons.json")
    val request =  jsonHelper.getRequest(requestFile) //("data/request.json")

    var usersList = new ListBuffer[User]()

    val validClients = clients.filter(client => client.hasValidPhoneAndEmail)
      .filter((client => client.hasValidAge))

    val validPersons = persons.filter(person => person.hasValidPhoneAndEmail)
      .filter(person => person.hasValidAge)

    usersList = clients.toUsersList
    usersList.addAll(persons.toUsersList())

    val filteredUsersList = usersList.filter(user => user.filterByRequest(request(0))).toList

    //jsonHelper.writeUsersToFile("data/users.json", filteredUsersList)
    filteredUsersList.foreach(user => println(user))
  }
}
