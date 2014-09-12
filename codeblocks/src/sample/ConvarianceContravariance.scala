package sample
class Animal[-T](name:String){
	override def toString = "I'm Animal, my name is "+name
}
class Dog[+T](name:String) extends Animal(name){
	override def toString = "I'm Dog, my name is "+name
}
class WhiteDog[T](name:String) extends Dog(name) {
	override def toString = "I'm WhiteDog, my name is "+name
}

object ConvarianceContravariance {

	def main(arg:Array[String]) = {
		
		var animals:Array[Animal[String]] = Array(new Animal("Jack"),new Animal("Mick"),new Dog("Ashy"))
		animals foreach println
		
		var whitedogs:WhiteDog[Dog[Int]] = new WhiteDog("Smart")
		var dogs:Dog[Any] = new Dog("Ashy")
		dogs = whitedogs 
		 
		println(dogs)
	}
}