package scala_exam.models

trait User {
  def filterByRequest(request: Request) : Boolean
}

