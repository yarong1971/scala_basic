package com.demo.traits.quoter

case class MessageQuoter(var message: String) extends Quoter {
  override def printMessage(): Unit = println(message)
}
