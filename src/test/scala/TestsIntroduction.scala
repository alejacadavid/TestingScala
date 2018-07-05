import org.scalatest.FunSuite
import org.scalatest.Matchers._

import scala.collection.mutable.ListBuffer

class TestsIntroduction extends FunSuite {
  test("Hello World") {
    val n = 3
    var i = 0
    for (i <- 1 to n) {
      println("Hello World")
    }
  }

  def g(x: Int, n: Int) = {
    var i =0
    val lis = ListBuffer.empty[Int]
    for(i <- 1 to n){
      lis += x
    }
    lis.toList
  }


  test("List Replication"){
      val n = 5
      val lis = List(1,2,3,4)
      //println(lis.flatMap(x => g(x,n)))
  }

  test("remove"){
    val lis = List(1,2,3,4,3,6,2,2)


    val ind = lis.indices.toList

    //val res = lis.filter(x => indices % 2 != 0)
    //println(res)

    println(lis.grouped(2).map(_.head))


    val reszip = lis zip ind

    val res = reszip.filter(x=> x._2%2 == 0)




  }


}
