import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestIterables extends FunSuite{

  //Iterables: Set, List, Vector, Stacks and Stream
  test("iterator"){

    //iterator and toIterator is the same function
    val list = List(3,5,9,10)
    val it = list.iterator
    if(it.hasNext) it.next() should be (3)

    val it2 = list.toIterator
    if(it2.hasNext) it2.next() should be (3)
  }

  test("list grouped"){
    val list = List(1,2,3,4,5)
    val it = list.grouped(3)

    it.next() should be(List(1,2,3))
    it.next() should be(List(4,5))


  }

  test("sliding"){
    val list = List(1,2,3,4,5)
    val it = list sliding(3)

    it.next() should be (List(1,2,3))
    it.next() should be (List(2,3,4))
  }

  test("sliding2"){
    val list = List(1,2,3,4,5,6)
    val it = list sliding(3,3) // Same function that grouped

    it next() should be (List(1,2,3))
    it next() should be (List(4,5,6))

  }

  test("take"){
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    list.take(2) should be (List(3,5)) //Take the first elements
    list.takeRight(3) should be (List(21,24,32)) //Take the last elements
  }

  test("drop"){
    val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
    list.drop(3) should be (List(11,15,19,21,24,32)) //Drop n elements of list
    list.drop(6) should be (List(21,24,32))
    list.dropRight(3) should be (List(3,5,9,11,15,19))
  }

  test("zip"){
    //Iterable(x1, x2, x3) zip Iterable(y1, y2, y3) will return ((x1, y1), (x2, y2), (x3, y3))
    val xs = List("Hello", "in")
    val ys = List("World", "english")

    (xs zip ys) should be (List(("Hello","World"),("in","english")))
  }


  test("zipAll"){
    //When the lists aren't the same size
    val x = List("Hello", "World")
    val y = List(1,2,3)

    (x zipAll(y,"?","b")) should be (List(("Hello",1),("World",2),("?",3)))
    (y zipAll(x,"b","?")) should be (List((1,"Hello"),(2,"World"),(3,"?")))

  }

  test("zipWithIndex"){
    val xs = List("Manny", "Moe", "Jack")
    xs.zipWithIndex should be (List(("Manny",0),("Moe",1),("Jack",2)))
  }

  test("sameElements"){
    val xs = List("Manny", "Moe", "Jack")
    val ys = List("Manny", "Moe", "Jack")
    (xs sameElements ys) should be(true)

    val xt = List("Manny", "Moe", "Jack")
    val yt = List("Manny", "Jack", "Moe")
    (xt sameElements yt) should be(false)

    val xs1 = Set(3, 2, 5, 4, 1, 6, 7, 2)
    val ys1 = Set(7, 2, 1, 2, 5, 6, 3, 4)
    println(xs1)
    println(ys1)
    (xs1 sameElements ys1) should be(true)

    val xt1 = Set(1, 2, 3)
    val yt1 = Set(3, 2, 1)
    println(xt1)
    println(yt1)
    (xt1 sameElements yt1) should be(false)

  }



}
