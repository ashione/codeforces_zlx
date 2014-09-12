//package codeblocks
import java.util.Scanner
object cf413A {
	def main(args : Array[String]) : Unit = {
	val scn = new Scanner(System.in)
	val caroli :List[Int] = {for(i <- 1 to 4 ) yield scn.nextInt}.toList
	val seq:List[Int] = scn.next.toList.map(_-'0')
	var sum =0
	seq.foreach(x=>sum+=caroli(x - 1))
	println(sum)
		
	}
	
//	def getResult(seq:List[Int],caroli:List[Int]):Int = {
//		val (head,tail) = seq.splitAt(4)
//		if(head.isEmpty) 0
//		else{
//			
//			val place = getRightPlace(head,head.length)
//			if(place!=0)
//			{
//				val (shead,thead) = head splitAt place-1
//				caroli(place-1)+getResult(shead:::thead.tail:::tail,caroli)
//			}
//			else 
//				0
//
//		}
//	}
//	def getRightPlace(xs:List[Int],n:Int ):Int = {
//		if(n == 0) 0
//		
//		if(xs(n-1)==n) n 
//		else getRightPlace(xs take n-1,n-1)
//		
//	}

}