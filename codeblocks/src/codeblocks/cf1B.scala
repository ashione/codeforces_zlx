package codeblocks

object cf1B {
	import java.util.Scanner
	val sc = new Scanner(System.in)
	def main(args : Array[String]) : Unit = {
		val n = sc.nextInt
//		println(rechange("BA23"))
//		println(change("R23C55"))
		for(i <- 1 to n){
			val st = sc.next
			if(st(0)=='R' && st(1).isDigit && st.contains('C'))
				println(change(st))
			else
				println(rechange(st))
		}
	}
	def change(st:String):String = {
		val (s1,s2) = (st drop 1 ) span (_.isDigit)
		var num = 0
		s2 drop 1 foreach(c => (num*=10,num+=c.toInt-'0'))
		var s=""
		while(num>0){
			val mod = num%26 
			num/=26
			s+=('A'-1 + ( if(mod==0) {num-=1;26} else mod)).toChar
		}
		s.reverse+s1
	}
	def rechange(st:String):String = {
		val (s1,s2) = st.span(c => c.isLetter)
		var sum = 0
		s1 foreach (c =>(sum*=26,sum=sum+(c.toInt-'A'.toInt+1)))
		"R"+s2+"C"+sum
	}

}