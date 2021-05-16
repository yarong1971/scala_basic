package com.demo.traits.quoter

class ShakespearQuoter(val quote: String = "Shakespear Quote: \"to be or not to be\"") extends Quoter {
  override def printMessage(): Unit = println(quote)
}
