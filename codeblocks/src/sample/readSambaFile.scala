package sample

import java.io._
import java.util.Scanner

object readSambaFile {

	def main(args : Array[String]) : Unit = {
		val file = new java.io.File("/mnt/sata/LDCDIST/LDC2011E06/events/E001/")
		
		val lists = file.listFiles.toList
		println(lists.length)
		val start = System.currentTimeMillis
		var space:Long = 0					
		lazy val buffer = new Array[Byte](0xfffffff) 
		lists take 3 foreach (
					x =>{
					println("Hers is "+x.getName)
					if(!x.isDirectory){
					val mread = new java.io.FileInputStream(x)
					mread.read(buffer, 0, x.length.toInt)
					val write = new java.io.FileOutputStream("/home/tj/cptest/"+x.getName)
					write.write(buffer, 0, x.length.toInt)
					println(x.getName+"is finished!")
					space+=x.length
					mread.close()
					write.close()

					}
		})
		val end = System.currentTimeMillis
		println("total time is "+(end-start),"Space are "+space.toFloat/(1<<20)+"MB")
		println("Speed is "+(space.toDouble/((end-start).toFloat/1000)/(1<<20))+"MB/s")
	}

}