package com.czn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberUtilTest extends AnyFlatSpec with Matchers {

  "An iterator of integers" should "produce a Map with the correct leading digit occurrence count" in {

    val arrayOfBigInts = Array(112, 3232, 23232, 221, 11, 111, 788).map(BigInt(_))

    val mapWithOccurrences = NumberUtil.leadingDigitOccurrenceCount(arrayOfBigInts.iterator)

    mapWithOccurrences(1) shouldBe 3
    mapWithOccurrences(2) shouldBe 2
    mapWithOccurrences(3) shouldBe 1
    mapWithOccurrences(7) shouldBe 1
  }

}
