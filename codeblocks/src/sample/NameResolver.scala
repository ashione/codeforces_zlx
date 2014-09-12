package sample

import scala.actors.Actor
import scala.actors.Actor._
object NameResolver extends Actor {

	import java.net.{InetAddress,UnknownHostException}
	val actorSelf = self
	def act(){
		react {
			case (name:String,actor: Actor) => 
				actor ! getIp(name)
				act()
			case "EXIT" =>
				println("Name resolver exiting.")
				//exit from act
			case msg =>
				println("Unhandled meesage: "+msg)
				act()
			case x => println(x)
		}
	}
	def getIp(name:String):Option[InetAddress] = {
		try {
			Some(InetAddress.getByName(name))
		}
		catch{
			case _:UnknownHostException => None
		}
	}
	def pf(s:Any) = {
		println(s)
	}
	def main(args: Array[String]) {
		NameResolver.start
		NameResolver ! ("www.baidu.com",actorSelf)
		 actorSelf.receiveWithin(1000) { case x => pf(x) } 

	
		NameResolver ! ("wwww.scala-lang.org",self)
		self.receiveWithin(1000) { case x => pf(x) }
	}
}
