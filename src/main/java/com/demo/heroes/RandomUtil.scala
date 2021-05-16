package com.demo.heroes

import scala.util.Random

object RandomUtil {

  def getNumberBetween(min:Int, max:Int): Int = Random.nextInt(max - min) + min + 1
}
