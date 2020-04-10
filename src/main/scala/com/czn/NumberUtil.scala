package com.czn

object NumberUtil {

  private val leadingDigit: BigInt => Int = (number: BigInt) => number.toString.substring(0, 1).toInt

  def leadingDigitOccurrenceCount(distribution: Iterator[BigInt]): Map[Int, Int] = {
    distribution.foldLeft[Map[Int, Int]](Map.empty[Int, Int])(
      (mapToReturn, currentValue) => {
        // Find the leading digit of the number
        val leadingDigitCount = leadingDigit(currentValue)
        mapToReturn.updatedWith(leadingDigitCount)({
          case None               => Some(1)
          case Some(currentCount) => Some(currentCount + 1)
        })
      }
    )
  }

}
