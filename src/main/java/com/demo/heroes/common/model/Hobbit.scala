package com.demo.heroes.common.model

import com.demo.heroes.services.Hero

case class Hobbit() extends Hero {

  override var hp: Int = 10
  override var power: Int = 0

  override def kick(enemy: Hero): Unit = cry()

  def cry(): Unit = println("Hobbit is crying.......")
}
