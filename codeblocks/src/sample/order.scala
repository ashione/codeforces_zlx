package sample

import scala.util.Random
import java.util.Scanner
/**
 * @param x
 * @param y
 */

case class Point(x:Int, y:Int) extends Ordered[Point] {
	override def compare(that:Point) = ( if(x!=that.x) (x-that.x)  else  (y-that.y))
	override def <(that:Point) = compare(that)<0  
	override def >(that:Point) = compare(that)>0
	//override def ==(that:Point) = compare(that)==0
}

object cmp{
	def main(args: Array[String]) {
		Random.setSeed(System.currentTimeMillis())
		val sc = new Scanner(System.in)
		val n = sc.nextInt
		val MOD:Int=65536
		val ls:Array[Point] = {for(i <- 1 to n) yield new Point(Random.nextInt()%MOD,Random.nextInt()%MOD)}.toList.toArray
		val start = System.currentTimeMillis
		quickSort(ls)
		val end = System.currentTimeMillis
		println("quicksort time cost was "+(end-start))
		
		val start2 = System.currentTimeMillis
		ls.sorted
		val end2 = System.currentTimeMillis
		println("general time cost was "+(end2-start2))
		
	}
	def quickSort[T <:Point](xs:Array[Point]):Array[Point] = {
		if(xs.length<=1) xs
		else{
			Array.concat(
					quickSort(xs filter (xs.head > )),
					xs filter (xs.head ==),
					quickSort(xs filter (xs.head < ))
			)
		}
	}
}