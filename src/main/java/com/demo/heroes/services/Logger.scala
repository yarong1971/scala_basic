package com.demo.heroes.services

object Logger {

  def logSelectedHeroes(h1:Hero, h2:Hero): Unit = {
    println(h1.getName() + "> power: " + h1.power + ", hp: " + h1.hp)
    println(h2.getName() + "> power: " + h2.power + ", hp: " + h2.hp)
    println("-------------------------------------------")
  }

  def logHobbitsDontFight :Unit = {
    println("This is a fight between Hobbits. Hobbits don't fight, they cry :(")
  }

  def logElfsDontFight :Unit = {
    println("This is a fight between Elfs. Elfs don't fight each other!")
  }

  def logGameOver(h1:Hero, h2: Hero):Unit ={
    println(h2.getName() + " is dead. " + h1.getName() + " wins.")
  }

  def logAtack(hero1:Hero, hero2: Hero):Unit = println(hero1.getName() + " is hit the " + hero2.getName())

  def logDamage(hitHero:Hero, attackedHero: Hero, hpBefore: Int):Unit = {
    if (attackedHero.hp <= 0)
      println(hitHero.getName() + " was kill the " + attackedHero.getName())
    else if(hitHero.getName().equals("Elf"))
      println(attackedHero.getName() + "lost 1 from his power")
    else{
      val lostHp = hpBefore - attackedHero.hp
      println(attackedHero.getName() + " lost " + lostHp + " from his hp")
    }
  }
}
