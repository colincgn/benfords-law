package com.czn

import scala.io.Source
import scala.util.{Failure, Success, Using}

object Main {

  def main(args: Array[String]): Unit = {

    if (args.isEmpty) {
      printUsage
    } else {
      val dataDistributionFile =
        Using(Source.fromFile(s"data/${args.head}")) { source =>
          source.getLines
          val bufferedIterator = source.getLines
          NumberUtil.leadingDigitOccurrenceCount(bufferedIterator.map(BigInt(_)))
        }

      dataDistributionFile match {
        case Success(distributionMap) =>
          if(BenfordsLaw.doesConform(distributionMap)) {
            println("Success!  Conforms to Benfords Law")
          } else {
            println("Failed! Does not conform to Benfords Law")
          }
        case Failure(_) =>
          println("There was an error processing the file, please make sure it exists and contains valid integers only")
          printUsage
      }
    }


  }

  def printUsage: Unit = {
    val usage =
      """
        |This application determines if a file containing a list of numbers conforms to Benford's law
        | Create a file with positive integers and add it to the data folder
        | usage: ./benfords-law dataDistribution.txt
        |""".stripMargin
    println(usage)
  }

}
