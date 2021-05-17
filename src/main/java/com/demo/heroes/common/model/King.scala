package com.demo.heroes.common.model

import com.demo.heroes.services.RandomUtil.getNumberBetween
import com.demo.heroes.services.WeaponStrategy
import com.demo.heroes.services.{Hero, WeaponStrategy}

case class King() extends Hero {

  override var power = getNumberBetween(5, 15)
  override var hp = getNumberBetween(5, 15)

  private def weapon: WeaponStrategy = new Sword(this)

  override def kick(enemy: Hero): Unit = weapon.kick(enemy)
}
