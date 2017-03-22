package codekata.ddcn

import codekata.ddcn.RomanNumeralKata._
import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralKataSpec extends FlatSpec with Matchers {

	"ArabicToRoman" should "convert first 3 numbers respectively" in {
		arabicToRoman(40) should be("XL")
		arabicToRoman(1) should be("I")
		arabicToRoman(2) should be("II")
		arabicToRoman(3) should be("III")
	}

	it should "random test" in {
    arabicToRoman(14) should be("XIV")
		arabicToRoman(39) should be("XXXIX")
  }

	it should "convert icon numberts to roman respectively" in {
		arabicToRoman(1) should be("I")
		arabicToRoman(5) should be("V")
		arabicToRoman(10) should be("X")
		arabicToRoman(50) should be("L")
		arabicToRoman(100) should be("C")
		arabicToRoman(500) should be("D")
	}

	it should "not have any icon symbol repeated more than 3 times" in {
		arabicToRoman(4) should be("IV")
		arabicToRoman(9) should be("IX")
		arabicToRoman(39) should be("XXXIX")
		arabicToRoman(40) should be("XL")
		arabicToRoman(49) should be("XLIX")
		arabicToRoman(89) should be("LXXXIX")
		arabicToRoman(99) should be("XCIX")
	}

	it should "subtract I, X and C from the next value to display roman numeral" in {
		arabicToRoman(4) should be("IV")
		arabicToRoman(9) should be("IX")
		arabicToRoman(40) should be("XL")
		arabicToRoman(90) should be("XC")
		arabicToRoman(400) should be("CD")
	}

}
