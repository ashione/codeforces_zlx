package sample
import scala.math._
object scalaTest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val w= Array[Double](1,2,3,4,5,6)               //> w  : Array[Double] = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
  sqrt(w.foldLeft(0.0)((z,x)=>z+(x*x)))           //> res0: Double = 9.539392014169456
}