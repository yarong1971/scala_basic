package com.demo.heroes

trait Hero {

  var power:Int
  var hp:Int

  def kick(enemy: Hero) : Unit
  def isAlive() : Boolean = hp > 0
}
