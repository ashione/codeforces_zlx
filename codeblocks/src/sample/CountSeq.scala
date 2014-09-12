package sample

object Count{	
	
//	val votes = Seq((2,1),(3,3),(2,7),(4,5),(3,6),(5,2))
	val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10),
					("c++",7),("scala",2),("python",3),("c",3))
		
	def main(args: Array[String]) {
	
		countTest1
		countTest2
	}
	/***方法一（没有语言格式）：先一步按类型将投票分组，映射到类型上（其中有一个求和利用的是foldLeft）
	 * def
		foldLeft[B](z: B)(op: (B, (A, B)) ⇒ B): B
	B  : the result type of the binary operator.
	z  : the start value.
	op : the binary operator.
	returns
	the result of inserting op between consecutive elements of this traversable or iterator, going left to right with the start value z on the left:
	op(...op(z, x_1), x_2, ..., x_n)
	 * **/
	def countTest1() = {
		val orderedVotes = votes
		.groupBy(_._1)
		.map {
			case (which,counts) => 
				(which,counts.foldLeft(0)(_+_._2))
		}.toSeq
		.sortBy(_._2)
		.reverse
		println(orderedVotes)
	}
	/***
	 * 第二中则显示了中间过程。推荐分步使用。
	 */
	def countTest2() = {
		val votesGroup = votes.groupBy{ case (item,_) => item }
		val groupCount = votesGroup.map{
			case (item,counts) =>
			val countOnly = counts map { case (_,count) => count}
//			println("countOnly is "+countOnly)
//			println("counts is "+counts)
			(item,countOnly.sum)
		}
		val orderedVotes = groupCount.toSeq.sortBy{ case(_,num) => num }.reverse
		
		println(orderedVotes)
	}
}
