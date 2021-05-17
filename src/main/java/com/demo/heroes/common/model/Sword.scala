package com.demo.heroes.common.model
import com.demo.heroes.services._

class Sword(private var attacker: Hero) extends WeaponStrategy {

  override def kick(defender: Hero): Unit = {
    val damage = RandomUtil.getNumberBetween(0, attacker.power)
    defender.hp-= damage
  }
}
