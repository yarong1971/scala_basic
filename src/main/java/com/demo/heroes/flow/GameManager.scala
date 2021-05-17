package com.demo.heroes.flow

import com.demo.heroes.common.model.{Elf, Hobbit}
import com.demo.heroes.services.{Hero, HeroFactory, Logger}

object GameManager {

  val heroFactory = HeroFactory
  val logger = Logger

  println(heroFactory.heroes)

  val h1 = heroFactory.createRandomHero
  val h2 = heroFactory.createRandomHero



  def start(): Unit ={
    logger.logSelectedHeroes(h1, h2)
    fightWithRandomHeroes(h2, h1)
  }

  private def fightWithRandomHeroes(h1: Hero, h2: Hero): Unit = {
    (h1, h2, h1.isAlive(), h2.isAlive()) match {
      case (h1: Hobbit, h2: Hobbit, _, _) => logger.logHobbitsDontFight
      case (h1: Elf, h2: Elf, _, _) => logger.logElfsDontFight
      case (_, _, true, false)  => logger.logGameOver(h1, h2)
      case (_, _, false, true)  => logger.logGameOver(h2, h1)
      case (_, _, true, true)  => {
        h1.kick(h2)
        fightWithRandomHeroes(h2, h1)
      }
    }
  }
}
