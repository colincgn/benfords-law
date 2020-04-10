package com.czn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ApproximatorTest extends AnyFlatSpec with Matchers {


  "Two floating numbers" should "be equal if they are within 2 percent of each other" in {
    Approximator.isAppromixatelyEqual(1.2F, 2F) shouldBe true
    Approximator.isAppromixatelyEqual(2.2F, 2F) shouldBe true
    Approximator.isAppromixatelyEqual(2F, 1.2F) shouldBe true
    Approximator.isAppromixatelyEqual(2.2F, 2F) shouldBe true
    Approximator.isAppromixatelyEqual(2F, 0) shouldBe true
  }

  it should "not be equal if they are not within 2 percent of each other" in {
    Approximator.isAppromixatelyEqual(4.1F, 2F) shouldBe false
    Approximator.isAppromixatelyEqual(2.1F, 0) shouldBe false
    Approximator.isAppromixatelyEqual(3.1F, 1) shouldBe false
  }

}
