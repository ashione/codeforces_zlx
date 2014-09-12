package codeblocks

import java.util.Scanner
object cf431C {
	val MOD:Int = 1000000007
	def main(args : Array[String]) : Unit = {
		
		val sc = new Scanner(System.in)
		val n,k,d = sc.nextInt
		val dp = Array.ofDim[Int](105, 2)
		
		dp(0)(0) = 1
		
		for(i <- 0 until n; j<- 0 to 1;r<- 1 to k){
			
			if(i+r<=n){
				val flag = if(j==1 || r>=d) 1 else 0
				dp(i+r)(flag) = (dp(i)(j)+dp(i+r)(flag))% MOD
			}
		}
		println(dp(n)(1))
	}

}