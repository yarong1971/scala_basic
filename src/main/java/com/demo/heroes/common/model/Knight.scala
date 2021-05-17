package com.demo.heroes.common.model

import com.demo.heroes.services.RandomUtil.getNumberBetween
import com.demo.heroes.services._

case class Knight() extends Hero {

  override var power = getNumberBetween(2, 12)
  override var hp = getNumberBetween(2, 12)

  private def weapon: WeaponStrategy = new Sword(this)

  override def kick(enemy: Hero): Unit = weapon.kick(enemy)
}
