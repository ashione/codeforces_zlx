package codeblocks
//把矩形分成四个部分，第一部分为可以完全覆盖，
//下和右部分而按长宽计算，最后剩
//下的一块就足够
object cf1A {
	import java.util.Scanner
	val sc = new Scanner(System.in)
	def main(args : Array[String]) : Unit = {
		val n,m,a = sc.nextLong
		print(		  (if(m%a!=0)(n/a) else 0)
					+ (if(n%a!=0) (m/a) else 0)
					+ (if(n%a!=0 && m%a!=0) 1 else 0)
					+(n/a)*(m/a))
	}

}