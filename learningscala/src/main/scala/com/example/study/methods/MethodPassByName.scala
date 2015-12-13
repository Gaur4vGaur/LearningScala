package com.example.study.methods

/**
 * The class displays the difference between passing and argument 
 * and passing a function. Note the difference when exactly the value
 * of argument is getting calculated
 *
 * Another thing to note in this program is how the calls for Another 
 * object are getting executed.
 * Execute the program and observe the calls in Another object and after 
 * that uncomment Another object and observe the calls for Another object
 *
 * @author Gaurav Gaur
 *
 **/

object MethodPassByName {

	def value1(): Int = {println("fetching value 1...");1}
	def value2(): Int = {println("fetching value 2...");2}

	def passingArg(n: Int): Unit = {
		println("Arg received: ")
		println(n)
	}

	println("\n\n")

	def passingFunction(n: => Int): Unit = {
		println("function received: ")
		println(n)
	}

	passingArg(value1())
	passingFunction(value2())

	//AnotherObject

	def main(args: Array[String]): Unit = {

		println("\n main method \n")
		AnotherObject.methodCall
	}
}

object AnotherObject {

	println("\n\nI am getting executed")

	def methodCall():Unit = {println("method call")}
}