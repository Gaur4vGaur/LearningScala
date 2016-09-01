package com.example.study.traits

/**
 * The program shows the usage of mixins and stackable modifications
 * Take a look at the output on how order of traits make the difference
 *
 * @author Gaurav Gaur
 *
 **/
object MixinTester {
	def main(args:Array[String]) = {
		val cat: Cat = new Cat with FourLegged with HasLegs
		val cat1: Cat1 = new Cat1 with HasLegs with FourLegged
		cat.methodToOverride()
		cat1.methodToOverride()
	}
}

class Animal() {

	def methodToOverride(s: String = "") = { 
		println(s"Final Animal value is $s")
	}
}

trait Furry extends Animal {
	abstract override def methodToOverride(s: String = "") = {
		super.methodToOverride(s + " Furry")
	}
}

trait HasLegs extends Animal {
	abstract override def methodToOverride(s: String = "") = {
		super.methodToOverride(s + " HasLegs")
	}
}

trait FourLegged extends Animal {
	abstract override def methodToOverride(s: String = "") = {
		super.methodToOverride(s + " FourLegged")
	}
}

class Cat extends Animal 

class Cat1 extends Animal