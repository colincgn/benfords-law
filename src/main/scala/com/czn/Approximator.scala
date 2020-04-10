package com.czn

object Approximator {

  private val AcceptableVariancePercentage = 2F

  def isAppromixatelyEqual(value: Float, approximateValue: Float): Boolean = {
    Math.abs((value - approximateValue)) <= AcceptableVariancePercentage
  }
}
