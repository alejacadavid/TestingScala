
import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsPatternMatching extends FunSuite {

  test("test1"){

    val stuff = "blue"

    val myStuff = stuff match {
      case "red" ⇒
        println("RED"); 1
      case "blue" ⇒
        println("BLUE"); 2
      case "green" ⇒
        println("GREEN"); 3
      case _ ⇒
        println(stuff); 0 // case _ will trigger if all other cases fail.


    }
    myStuff should be(2)
  }


  test("test2"){

    val secondElement = List(1, 2, 3) match {
      case x :: xs ⇒ xs.head // x is head, xs is tail
      case _ ⇒ 0
    }

    secondElement should be(2)
  }

  test("test3"){
    val secondElement = List(1, 2, 3) match {
      case x :: y :: xs ⇒ y //x first, y second, xs tail
      case _ ⇒ 0
    }

    secondElement should be (2)

    val e = List(1) match {
      case x :: y :: xs ⇒ y //x first, y second, xs tail
      case _ ⇒ 0
    }

    e should be (0)

    val r = List(1, 2, 3) match {
      case x :: y :: Nil ⇒ y // only matches a list with exactly two items
      case _ ⇒ 0
    }

    r should be(0)

  }



}
