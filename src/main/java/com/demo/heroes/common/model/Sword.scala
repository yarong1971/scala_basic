package com.demo.heroes.common.model
import com.demo.heroes.services._

class Sword(private var attacker: Hero) extends WeaponStrategy {

  override def kick(defender: Hero): Unit = {
    val damage = RandomUtil.getNumberBetween(0, attacker.power)
    val defenderName = defender.getClass.getSimpleName
    val attackerName = attacker.getClass.getSimpleName
    defender.hp-= damage
    println(attackerName + " kick with a sword to " + defenderName + " for " + damage + " hp  --> [hp left] " +
                                                      attacker.getName() +": " + attacker.hp + ", " + defender.getName() +": " + defender.hp)
  }
}
