package com.demo.heroes

import com.demo.heroes.RandomUtil.getNumberBetween

case class King() extends Hero {

  override var power = getNumberBetween(5,15)
  override var hp = getNumberBetween(5,15)

  private def weapon: WeaponStrategy = new Sword(this)
  override def kick(enemy: Hero): Unit = weapon.kick(enemy)
}
