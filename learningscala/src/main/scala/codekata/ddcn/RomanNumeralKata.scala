package codekata.ddcn

import IconNumbers._
import IconRoman._

object RomanNumeralKata {

  def arabicToRoman(input: Int): String = {

    def calculate(arabic: Int, result: String = "", shouldAppend: Boolean = true): String = {
      arabic match {
        case lessThanFour if lessThanFour < 4 =>
          if (shouldAppend) result + (oneR * lessThanFour)
          else (oneR * lessThanFour) + result
        case lessThanNine if lessThanNine < 9 =>
          if (lessThanNine < five) result + calculate((five - lessThanNine), fiveR, false)
          else calculate((lessThanNine % five), fiveR + result, true)
        case lessThanThirtyNine if lessThanThirtyNine < 40 =>
          if (lessThanThirtyNine < ten) result + calculate((ten - lessThanThirtyNine), tenR, false)
          else calculate((lessThanThirtyNine % ten), (tenR * (lessThanThirtyNine / ten)) + result, true)
        case lessThanNinety if lessThanNinety < 90 =>
          if (lessThanNinety < fifty) result + calculate((fifty - lessThanNinety), fiftyR, false)
          else calculate((lessThanNinety % fifty), (fiftyR * (lessThanNinety / fifty)) + result , true)
        case _ => "roman"
      }
    }

    val result = calculate(input)
    println("\n" + input + "  " + result)
    result
  }

  def romanToArabic(roman: String) = {
    println("converting Roman to Arabic")
    0
  }

}

object IconRoman {
  val oneR = "I"
  val fiveR = "V"
  val tenR = "X"
  val fiftyR = "L"
  val hundredR = "C"
  val fiveHundredR = "D"
}

object IconNumbers {
  val one = 1
  val five = 5
  val ten = 10
  val fifty = 50
  val hundred = 100
  val fiveHundred = 500
}
