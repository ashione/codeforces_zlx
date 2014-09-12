package sample
import java.io._
import java.util.Scanner

object analysisHtmlPdf {

	def main(args : Array[String]) : Unit = {
		val file = new java.io.File("/home/tj/Documents/spark-submit2014/agenda")
		val read = new java.io.FileReader(file)
		val write = new java.io.FileWriter("/home/tj/pdflist")
		lazy val buffer:Array[Char] = new Array[Char](file.length.toInt) 
		read.read(buffer)
		var str = ""
		var end:Int = 0
		for(s<-buffer){
			if(s==''' || s=='"')
				end=end^1
				//这会将第一个引号也读取进来，需要在后面去除
			if(end==1) {str=str+s;}
			else{
				if(str.endsWith(".pdf")){
					println(str drop 1)
					write.write((str drop 1)+'\n')
				}
					str=""
					end=0
				
			}
		}
		read.close()
		write.close()
	}

}