import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsLists extends FunSuite{

  test("list1"){

    val a = List("a","b","c")
    val b = List("a","b","c")

    (a eq b) should be (false) // eq tests identity (same object)
    (a == b) should be (true) // == tests content

  }

  test("List2"){
    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a==Nil) should be (true)
    (a eq Nil) should be (true)

    (b==Nil) should be (true)
    (b eq Nil) should be (true)

    (a == b) should be (true)
    (a eq b) should be (true)

  }

  test("HeadOfList"){

    val a = List(1, 2, 3)

    a.head should be (1) //insecure
    a.headOption should be (Some(1))

  }

  test("TailOfList"){
    val a = List(1,2,3)
    a.tail should be (List(2,3))
    a(0) should be (1)
  }

  test("FilterList"){

    val a = List(1,2,3)
    val b = a.filter(x => x==1)

    b should be (List(1))

    val c = a.filterNot(x => x==1)
    c should be (List(2,3))
  }

  test("FunctionsList"){

    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(5)

    // reverse the list
    a.reverse should equal(List(9,7,5,3,1))

    // map a function to double the numbers over the list
    a.map { v ⇒
      v * 2
    } should equal(List(2,6,10,14,18))

    a.map(_*2) should be (List(2,6,10,14,18))

    // filter any values divisible by 3 in the list
    a.filter { v ⇒
      v % 3 == 0
    } should equal(List(3,9))

    a.filter(x=> x%3 == 0) should be (List(3,9))
  }

  test("reduceAndFold"){

    val a = List(1, 3, 5, 7)

    a.reduceLeft(_+_) should be (16)
    a.reduceLeft(_*_) should be (105)

    a.foldLeft(0)(_+_) should be (16)
    a.foldLeft(1)(_*_) should be (105)

  }

  test("prepend"){
    val a = List(1, 3, 5, 7)

    0 :: a should be (List(0,1,3,5,7))

    val head = List(1, 3)
    val tail = List(5, 7)

    head ::: tail should be(List(1,3,5,7))
    head ::: Nil should be(List(1,3))

    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val z = 1 :: b

    z should be(List(1,2,3))
    z.tail should be( List(2,3))
    b.tail should be(List(3))
    c.tail should be(List())

  }



}
