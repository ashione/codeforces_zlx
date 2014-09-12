
//package codeblocks

import java.util.Scanner
import scala.math._
object cf441B {

	val sc = new Scanner(System.in)
	def main(args : Array[String]) : Unit = {
		val n,v = sc.nextInt
		var a = new Array[Long](3002)
		for(i <- 1 to n) a(sc.nextInt)+=sc.nextInt
		var counts:Long = 0
		for(i <-1 to 3001){
			val today =min(v, a(i)+a(i-1))
			counts+=today
			a(i) = if(today!=v) 0 else min(a(i),a(i)+a(i-1)-v)
		}
		println(counts)
	}

}