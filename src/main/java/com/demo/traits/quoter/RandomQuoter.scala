package com.demo.traits.quoter

import scala.util.Random

object RandomQuoter extends Quoter {
  var quotes = List("Love looks not with the eyes, but with the mind",
                    "Doubt thou the stars are fire",
                    "The fault, dear Brutus, is not in our stars, but in ourselves",
                    "The fool doth think he is wise, but the wise man knows himself to be a fool",
                    "Good night, good night! Parting is such sweet sorrow")

  override def printMessage(): Unit = {
    val random = new Random
    println("Ranadom Quote: " + quotes(random.nextInt(quotes.length)))
  }
}
