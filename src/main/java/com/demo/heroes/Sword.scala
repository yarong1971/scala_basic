package com.demo.heroes

class Sword(private var attacker: Hero) extends WeaponStrategy {

  override def kick(defender: Hero): Unit = {
    val damage = RandomUtil.getNumberBetween(0, attacker.power)
    val defenderName = defender.getClass.getSimpleName
    val attackerName = attacker.getClass.getSimpleName
    println(attackerName + " kick with a sword to " + defenderName + " for " + damage + "hp")
    defender.hp-= damage
  }
}
