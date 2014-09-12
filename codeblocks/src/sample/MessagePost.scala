package sample

import scala.actors.Actor._
object MessagePost {
	def main(agr:Array[String]):Unit = {
	var startTime :Long = 0
	val caller = self
	var mailboxSize = 0
	val engrossedActor = actor {
		println("Number of messages received so far?" + mailboxSize)
		caller ! "send"
		Thread.sleep(3000)
		println("Number of messages received while I was busy? "+mailboxSize)
		receive {
			case msg =>
				mailboxSize-=1
				val receivedTime = System.currentTimeMillis() - startTime
				println("Received message "+msg +"after "+receivedTime +" ms")
				
		}
		caller ! "receoved"
	}
	receive{ case _ =>}
	
	println("Sending Message")
	startTime = System.currentTimeMillis
	engrossedActor ! "Hello buddy"
	mailboxSize+=1
	val endTime = System.currentTimeMillis - startTime
	
	printf("Took less than %dms to send message\n",endTime)
	receive{
		case _ =>
	}
	}
}