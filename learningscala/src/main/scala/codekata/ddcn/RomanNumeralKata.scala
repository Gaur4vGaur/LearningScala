package codekata.ddcn

import IconNumbers._ 

object RomanNumeralKata {

	def arabicToRoman(arabic: Int, roman: String = ""): String = {
		arabic match {
			case lessThanFive if 5 % lessThanFive >= 3 => one * lessThanFive
			case lessThanFive if 5 % lessThanFive <= 1 => one * lessThanFive + five
			case fiveToTen if fiveToTen < 9 => five + one * (fiveToTen % 5)
			case 9 => one + ten
			case 10 => ten
		}
	}

	def romanToArabic(roman: String) = {
		println("converting Roman to Arabic")
		0
	}

}

object IconNumbers {

	val one = "I"
	val five = "V"
	val ten = "X"
	val fifty = "L"
	val hundred = "C"
	val fiveHundred = "D"
}
