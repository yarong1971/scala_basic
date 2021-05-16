package com.demo.heroes

import org.reflections.Reflections
import scala.jdk.CollectionConverters.CollectionHasAsScala

object HeroFactory {
  val scanner = new Reflections("heroes")
  val heroes = getHeroesList

  private def getHeroesList = {
    val set = scanner.getSubTypesOf(classOf[Hero])
    set.asScala.toList
  }

  def createRandomHero: Hero = {
    val randomNumber = RandomUtil.getNumberBetween(0,heroes.size)
    heroes(randomNumber).getDeclaredConstructor().newInstance()
  }
}
