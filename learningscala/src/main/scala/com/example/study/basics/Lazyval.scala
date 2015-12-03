package com.example.study.basics

object Lazyval {

	lazy val lazyVal1 = {println("lazy val 1 initialized"); 1}
	val val2 = {println("val 2 initialized"); 2}
	val val3 = {println("val 3 initialized"); 3}

	def main(args: Array[String]) {
		println("Main method printing values")
		println(lazyVal1)
		println(val2)
	}
}