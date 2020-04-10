package com.czn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BenfordsLawTest extends AnyFlatSpec with Matchers {

  "Given a map of integer keys with integer values" should "sum up all the values for every key in the map" in {
    val map: Map[Int, Int] = Map(
      1 -> 123,
      3 -> 344,
      8 -> 122
    )

    BenfordsLaw.sumValues(map) shouldEqual 589
  }

  it should "sum up all the values for every key in the map with negative values" in {
    val map: Map[Int, Int] = Map(
      1 -> 123,
      3 -> 344,
      8 -> -123
    )

    BenfordsLaw.sumValues(map) shouldEqual 344
  }

  "Given a known distribution (fibonacci)" should "confirm that it conforms to Benfords law" in {

    val fibSequence = (fibs take 500).toList

    val doesConform = BenfordsLaw.doesConform(NumberUtil.leadingDigitOccurrenceCount(fibSequence.iterator))
    doesConform shouldBe true
  }

  it should "not conform if a leading digit is missing" in {

    val fibSequence = (fibs take 500).toList

    val distributionMap = NumberUtil.leadingDigitOccurrenceCount(fibSequence.iterator)
    val mapWithMissingKey = distributionMap - 5
    val doesConform = BenfordsLaw.doesConform(mapWithMissingKey)
    doesConform shouldBe false
  }
  "Given a known distribution (linear increment)" should "that it does not conform to Benfords law" in {

    val linearDistribution = (1 to 5000).map(BigInt(_)).toList

    val doesConform = BenfordsLaw.doesConform(NumberUtil.leadingDigitOccurrenceCount(linearDistribution.iterator))
    doesConform shouldBe false
  }

  val fibs: LazyList[BigInt] = 0 #:: fibs.scanLeft(BigInt(1))(_ + _)
}
