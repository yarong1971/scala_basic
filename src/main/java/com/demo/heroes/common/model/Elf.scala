package com.demo.heroes.common.model

import com.demo.heroes.services.Hero

case class Elf() extends Hero {

  override var hp: Int = 10
  override var power: Int = 10

  override def kick(enemy: Hero): Unit = {
    if (power > enemy.power)
      enemy.hp = 0
    else
      enemy.power -= 1
  }
}
