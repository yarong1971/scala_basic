package com.demo.heroes.services

import com.demo.heroes.common.model.Hobbit

object Logger {

  def logSelectedHeroes(h1:Hero, h2:Hero): Unit = {
    println(" ===== " + h1.getName() + " vs " + h2.getName() + " =====")
    println("[" + h1.getName() + "] power: " + h1.power + ", hp: " + h1.hp)
    println("[" + h2.getName() + "] power: " + h2.power + ", hp: " + h2.hp)
    println("====== Fight Details ======")
  }

  def logHobbitsDontFight :Unit = {
    println("This is a fight between Hobbits. Hobbits don't fight, they cry :(")
  }

  def logElfsDontFight :Unit = {
    println("This is a fight between Elfs. Elfs don't fight each other!")
  }

  def logFightIsOver(h1:Hero, h2: Hero):Unit ={
    println(h2.getName() + " is dead. " + h1.getName() + " wins.")
  }

  def logAttack(attacker:Hero, defender: Hero, defenderPreviousHp: Int):Unit = {
    val damage = defenderPreviousHp - defender.hp
    if (!attacker.isInstanceOf[Hobbit]) {
        println(attacker.getName() + " kicks " + defender.getName() + " for " + damage + " hp  --> [hp left] " +
        attacker.getName() +": " + attacker.hp + ", " + defender.getName() +": " + defender.hp)
    }
  }
}
