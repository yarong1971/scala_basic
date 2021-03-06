package com.demo.heroes.services

trait Hero {

  var power: Int
  var hp: Int

  def kick(enemy: Hero): Unit

  def isAlive(): Boolean = hp > 0

  def getName() : String = this.getClass.getSimpleName
}
