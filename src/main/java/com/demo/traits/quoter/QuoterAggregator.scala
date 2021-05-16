package com.demo.traits.quoter

object QuoterAggregator {
  var quoterList: List[Quoter] = Nil

  def addQuoter(quoter: Quoter): Unit = {
    quoterList = quoter::quoterList
  }

  def printQuotes: Unit ={
    quoterList.foreach(_.printMessage())
  }
}
