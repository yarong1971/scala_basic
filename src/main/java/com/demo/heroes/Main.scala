package com.demo.heroes

import com.demo.heroes.flow.GameManager

object Main {
  def main(args: Array[String]): Unit = {
    val gameManager = GameManager
    gameManager.start()
  }
}
