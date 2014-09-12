package sample

import scala.actors.Actor._

object PerfectNumberFinder {

	def main(args : Array[String]) : Unit = {
		val p = Array[Int=>Boolean](isPerfect,isPerfectConcurrent)
		for(i <- 0 until p.length){
			val start = System.currentTimeMillis
			test1(p(i))
			val end = System.currentTimeMillis
			println(p(i).getClass().getName()+ " time is "+(end-start))
		}
		
	}
	def sumOfFactorsInRange(lower:Int,upper:Int,number:Int):Int = {
		( 0 /: (lower to upper)){(sum,i) =>  if(number%i==0) sum+i else sum}
	}
	def isPerfectConcurrent(candidate:Int) = {
//		println(candidate)
		val RANGE = 1e6.toInt
//		println(RANGE)
		val numberOfPartitions = (candidate.toDouble/RANGE).ceil.toInt
//		println(numberOfPartitions)
		val caller = self
		for(i <- 0 until numberOfPartitions){
			val lower = i*RANGE+1
			val upper = candidate min ((i+1)*RANGE)
//			println(lower,upper)
			
			actor {
				caller ! sumOfFactorsInRange(lower,upper,candidate)
			}
		}
		
		val sum = (0 /: (0 until numberOfPartitions)){ (sumOfPartition,i) =>
				receive{
					case sumInRange:Int => sumOfPartition+sumInRange
				}
		}
//		println(sum)
		(candidate<<1) == sum
	}
	def sumOfFactors(number:Int) = {
		( 0 /: (1 to number)){ (sum,i) => if (number%i ==0) sum+i else sum }
	}
	def isPerfect(candidate:Int):Boolean = {
		(candidate<<1) == sumOfFactors(candidate)

	}
	def test1(f:Int=>Boolean) = {
//		println("6 is perfect? " + f(6))
//		println("33550336 is perfect? " + f(33550336))
//		println("33550337 is perfect? " + f(33550337))
		(33550300 to 33550400) foreach (f)
	}
}