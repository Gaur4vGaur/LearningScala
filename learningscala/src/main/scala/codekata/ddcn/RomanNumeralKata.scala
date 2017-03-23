package codekata.ddcn

import IconNumbers._
import IconRoman._

object RomanNumeralKata {

  def arabicToRoman(arabic: Int): String = {

    val calculations2 = (convertToRoman: (Int, String, Boolean) => String, roman: String, lastIcon: Int) =>
      roman + convertToRoman((arabic % lastIcon), "", false)

    def calculations(input: Int, iconNumber: Int, romanSymbol: String, lastRoman: String) = {
      if (input < iconNumber) lastRoman
      else convertToRoman((input % iconNumber), romanSymbol, true)
    }

    def convertToRoman(arabic: Int, result: String = "", shouldAppend: Boolean = true): String = {
      arabic match {
        case lessThanFour if lessThanFour < 4 =>
          if (shouldAppend) result + (oneR * lessThanFour)
          else (oneR * lessThanFour) + result

        case lessThanNine if lessThanNine < 9 =>
          val lastRoman = calculations2(convertToRoman _, result + "IV", one)
          calculations(lessThanNine, five, result + fiveR, lastRoman)

        case lessThanThirtyNine if lessThanThirtyNine < 40 =>
          val lastRoman = calculations2(convertToRoman _, result + "IX", one)
          calculations(arabic, ten, result + (tenR * (arabic / ten)), lastRoman)

        case lessThanNinety if lessThanNinety < 90 =>
          val lastRoman = calculations2(convertToRoman _, result + "XL", ten)
          calculations(arabic, fifty, result + (fiftyR * (arabic / fifty)), lastRoman)

        case lessThanFourHundred if lessThanFourHundred < 400 =>
          val lastRoman = calculations2(convertToRoman _, result + "XC", ten)
          calculations(arabic, hundred, result + (hundredR * (arabic / hundred)), lastRoman)

        case lessThanThousand if lessThanThousand < 1000 =>
          if (lessThanThousand < fiveHundred) "CD" else fiveHundredR

        case _ => "yet to be converted"
      }
    }

    convertToRoman(arabic)
  }


  def romanToArabic(roman: String): Int = {
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
