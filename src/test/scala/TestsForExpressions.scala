import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsForExpressions extends FunSuite{

  test("testWithForAndYield"){
    val xVal = 1 to 4     // xVal = 1,2,3,4
    (xVal.toList) should be (List(1,2,3,4))

    val yVal = 1 to 2     // yVal = 1,2
    yVal.toList should be (List(1,2))

    val coord = for {
      x <- xVal
      y <- yVal
    } yield(x,y)

    coord(0) should be (1,1)
    coord(1) should be (1,2)
    coord(2) should be (2,1)
    coord(3) should be (2,2)
    coord(4) should be (3,1)
    coord(5) should be (3,2)
    coord(6) should be (4,1)
    coord(7) should be (4,2)
  }

  test("testWithOutYield"){

    val xVal = 1 to 4     // xVal = 1,2,3,4
    (xVal.toList) should be (List(1,2,3,4))

    val yVal = 1 to 2     // yVal = 1,2
    yVal.toList should be (List(1,2))

  /*  val coord = for {
      x <- xVal
      y <- yVal
    } yield(x,y)*/

    val rest = xVal.flatMap(x => yVal.map(y => (x,y)))

    rest(0) should be (1,1)
    rest(1) should be (1,2)
    rest(2) should be (2,1)
    rest(3) should be (2,2)
    rest(4) should be (3,1)
    rest(5) should be (3,2)
    rest(6) should be (4,1)
    rest(7) should be (4,2)
  }


  test("t2"){
    val nums = List(List(1),List(2),List(3),List(4),List(5))

    val res = for{
      numList <- nums   //numList = List(List)
      num <- numList    //num = List
      if(num % 2 == 0)
    } yield(num)

    res should be (List(2,4))
  }

  test("t2WithFlatMap"){
    val nums = List(List(1),List(2),List(3),List(4),List(5))
    nums.flatMap(numList => numList).filter(_%2==0) should be (List(2,4))
  }

  test("t3Filter"){
    val nums = List(1,2,3,4,5)
    nums.filter(_%2 == 0) should be (List(2,4))
  }

  test("flatMap4"){

    val fruits = List("apple", "orange","banana")

    fruits.map(_.toUpperCase()) should be (List("APPLE","ORANGE","BANANA"))
    fruits.flatMap(_.toUpperCase()) should be (List('A', 'P', 'P', 'L', 'E', 'O', 'R', 'A', 'N', 'G', 'E', 'B', 'A', 'N', 'A', 'N', 'A'))

    val fruits2 = List(List("apple"),List("orange"))
    fruits2.flatMap(_.map(_.toUpperCase())) should be (List("APPLE", "ORANGE"))
  }


  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }


  test("flatMap5"){
    val strings = List("1","2","foo")
    strings.map(toInt) should be (List(Some(1), Some(2), None))

    strings.flatMap(toInt) should be (List(1,2))
    strings.flatMap(toInt).sum should be (3)

  }

  def g(x: Int) = List(x-1,x,x+1)

  test("flatMap6"){
    val list = List(1,2,3,4,5)

    list.map(x => g(x)) should be (List(List(0,1,2),List(1,2,3),List(2,3,4),List(3,4,5),List(4,5,6)))

    list.flatMap(x => g(x)) should be (List(0,1,2,1,2,3,2,3,4,3,4,5,4,5,6))


  }

  def g1(x: Int) = List(x,x,x)

  test("flatMap7"){
    val list = List(1,2,3)

    list.map(x => g1(x)) should be (List(List(1,1,1),List(2,2,2),List(3,3,3)))

    list.flatMap(x => g1(x)) should be (List(1,1,1,2,2,2,3,3,3))

    println(list.flatMap(x=>List.fill(4)(x)))

  }

}
