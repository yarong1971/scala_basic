package com.demo.heroes

case class Hobbit() extends Hero {

  override var hp: Int = 3
  override var power: Int = 0
  override def kick(enemy: Hero): Unit = cry()

  def cry(): Unit = println("Hobbit is crying.......")
}
