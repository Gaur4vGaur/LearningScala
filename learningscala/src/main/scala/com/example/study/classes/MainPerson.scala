package com.example.study.classes


/**
 * An attempt to create a class with getters/setters in scala
 * Case class is used because it overrides toString by default
 * 
 * Note:
 * 1. The setter methods (age_=), here '_' plays an important role
 * It allows blank space (i.e age =) while calling this function, hence
 * it feels like your are accessing a public value of Persion
 *
 * 2. A combination of var and val in case classes
 *
 * @author Gaurav Gaur
 *
 **/
object MainPerson {

	def main(args: Array[String]) {

		val person = Person(30, "Gaurav", "Delhi")
		println("New person --> " + person)

		person.age = 31
		println("person after an year --> " + person)
	}
}

case class Person(var _age:Int, var _name:String, place: String) {

	def age = _age
	def age_=(value: Int) = _age = value

	def name = _name
	def name_=(value: String) = _name = value
}