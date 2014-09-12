package sample
import scala.math._
object scalaTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
  println("Welcome to the Scala worksheet");$skip(36); 
  val w= Array[Double](1,2,3,4,5,6);System.out.println("""w  : Array[Double] = """ + $show(w ));$skip(40); val res$0 = 
  sqrt(w.foldLeft(0.0)((z,x)=>z+(x*x)));System.out.println("""res0: Double = """ + $show(res$0))}
}
