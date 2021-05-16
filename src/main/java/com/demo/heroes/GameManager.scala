package com.demo.heroes

case class GameManager(){
  val heroFactory = HeroFactory

  def fightWithRandomHeroes(): Unit = {
    val h1 = heroFactory.createRandomHero
    val h2 = heroFactory.createRandomHero
    while (h1.isAlive && h2.isAlive) {
      h1.kick(h2)
      h2.kick(h1)
    }
    if (h1.isAlive) println(h1.getClass.getSimpleName + " won")
    else println(h2.getClass.getSimpleName + " won")
  }
}
