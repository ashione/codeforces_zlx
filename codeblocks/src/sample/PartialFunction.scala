package sample

object PartialFunction {

	def main(args : Array[String]) : Unit = {
		testPartialFunction2
	}
	def testPartialFunction1() = {
			val sample = 1 to 10
			val isEven: PartialFunction[Int, String] = {
			  case x if x % 2 == 0 => x+" is even"
			}
			
			// the method collect can use isDefinedAt to select which members to collect
			val evenNumbers = sample collect isEven
			
			val isOdd: PartialFunction[Int, String] = {
			  case x if x % 2 == 1 => x+" is odd"
			}
			
			// the method orElse allows chaining another partial function to handle
			// input outside the declared domain
			val numbers = sample map (isEven orElse isOdd)
			
			println(numbers)
	}
	def testPartialFunction2() = {
		val sample = 1 to 10
		val Square :PartialFunction[Int,Int] = {
			case x if x%2 ==0  => x*x
			case _ => 1
		}
		val Cube   :PartialFunction[Int,Int] = {
			case x if x%3 ==0  => x*x*x
			case _ => 0 
		}
		
		val number = sample map( Square andThen Cube)
		val number2 = sample map(Square compose Cube)
		println(number)
		println(number2)
		
	}

}