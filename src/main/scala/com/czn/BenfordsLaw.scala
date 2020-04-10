package com.czn

object BenfordsLaw {

  //  Assumption, these are static numbers straight from Wikipedia and I do not have to calculate them with the Log10(1 + 1/x) formula
  private lazy val BenfordsLaw: Map[Int, Float] = Map(
    1 -> 30.1F,
    2 -> 17.6F,
    3 -> 12.5F,
    4 -> 9.7F,
    5 -> 7.9F,
    6 -> 6.7F,
    7 -> 5.8F,
    8 -> 5.1F,
    9 -> 4.6F
  )

  /**
    * Determines if a map of numbers conform to Benfords Law
    * @param distributionMap A map of numbers, 1 to 9, with the instance occurrence count of each digit
    *  eg.  { 1 -> 32, 2 -> 234, 3 -> 433, 4 -> 2342, 5 -> 64, 6 -> 22, 7 -> 87, 8 -> 342, 9 -> 12 }
    * @return if the collection conforms or not
    */
  def doesConform(distributionMap: Map[Int, Int]): Boolean = {
    // Sum up all the occurrences for each leading digit as a total.
    val totalDataSetCount = sumValues(distributionMap)

    // forall checks, and returns a boolean, if the given predicate satisfies all the elements of the list or not
    1 to 9 forall { i =>
      //  For every number 1 through 9, find the distribution occurrence for it
      distributionMap.get(i) match {
        // If it's not in the map then this will not conform
        case None => false
        case Some(occurrences) =>
          // We do have an occurrence count for the integer i, so we need to calculate the % of times it occurred
          val occurrencePercentage = occurrences.toFloat / totalDataSetCount * 100
          // Now compare it to what we know it should be, an approximate if it is or not
          Approximator.isAppromixatelyEqual(occurrencePercentage, BenfordsLaw(i))
      }
    }
  }

  /**
   * Sum up all the values for all keys of the given map
   * @param map of integer keys with integer values
   * @return an Integer for the count of all the values for all keys
   */
  def sumValues(map: Map[Int, Int]): Int = {
    map.foldLeft(0) {
      case (accumulator, (_, valuesInteger)) => accumulator + valuesInteger
    }
  }

}
