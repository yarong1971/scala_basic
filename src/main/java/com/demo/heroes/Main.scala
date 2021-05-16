package com.demo.heroes

object Main {
  def main(args: Array[String]): Unit = {
    val gameManager = GameManager
    gameManager.apply().fightWithRandomHeroes()
  }
}
