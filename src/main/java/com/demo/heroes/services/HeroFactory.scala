package com.demo.heroes.services

import org.reflections.Reflections
import scala.jdk.CollectionConverters._

object HeroFactory {
  val scanner = new Reflections("com.demo.heroes")
  val heroes = getHeroesList

  private def getHeroesList = {
    val set = scanner.getSubTypesOf(classOf[Hero])
    set.asScala.toList
  }

  def createRandomHero: Hero = {
    val randomNumber = RandomUtil.getNumberBetween(0, heroes.size)
    println("Rnadom number: " + randomNumber)
    heroes(randomNumber-1).getDeclaredConstructor().newInstance()
  }
}
