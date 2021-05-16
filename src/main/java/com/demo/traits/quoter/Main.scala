package com.demo.traits.quoter

object Main {
  def main(args: Array[String]): Unit = {

    val quoterAggregator = QuoterAggregator
    quoterAggregator.addQuoter(new ShakespearQuoter("ShakespearQuote: \"Love all, trust a few, do wrong to none\""))
    quoterAggregator.addQuoter(new ShakespearQuoter())
    quoterAggregator.addQuoter(MessageQuoter("Message Quote: Be not afraid of greatness"))
    quoterAggregator.addQuoter(RandomQuoter)
    quoterAggregator.addQuoter(RandomQuoter)
    quoterAggregator.addQuoter(RandomQuoter)
    quoterAggregator.printQuotes
  }
}
