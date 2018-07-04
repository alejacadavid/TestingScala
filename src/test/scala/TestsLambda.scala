import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsLambda extends FunSuite{

  test("lambda1") {
    def lambda = { x: Int =>
      x + 1
    }

    def lambda2 = (x: Int) => x + 2
    val lambda3 = (x: Int) ⇒ x + 3

    val lambda4 = new Function1[Int, Int] {
      def apply(v1: Int): Int = v1 - 1
    }

    def lambda5(x: Int) = x + 1

    val result = lambda(3)
    val `result1andhalf` = lambda.apply(3)

    val result2 = lambda2(3)
    val result3 = lambda3(3)
    val result4 = lambda4(3)
    val result5 = lambda5(3)

    result should be(4)
    result1andhalf should be(4)
    result2 should be(5)
    result3 should be(6)
    result4 should be(2)
    result5 should be(4)
  }


  test("lambda2"){
    def summation(x: Int, y: Int => Int) = y(x)

    var inc = 3

    def closure = (x: Int) => x + inc

    val res1 = summation(10,closure)
    res1 should be(13)

    inc = 4

    val res2 = summation(10,closure)
    res2 should be (14)

  }

  test("lambdaWithOutSintaxSugar"){
    def add(x: Int): Function1[Int,Int] = {
      new Function1[Int, Int]() {
        def apply(y:Int): Int = x + y
      }
    }

    // a.isInstanceOf[B] returns boolean indicating whether a has type B or not.
    add(1).isInstanceOf[Function1[Int, Int]] should be (true)
    add(2)(3) should be (5)

    def add5: Function1[Int, Int] = add(5)
    add5(5) should be (10)

  }

  test("lambdaWithSintaxSugar"){
    def add(x: Int) = (y: Int) => x + y
    add(1).isInstanceOf[Function1[Int, Int]] should be (true)

    add(2)(3) should be (5)

    def add5 = add(5)
    add5(5) should be (10)

  }

  test("lambdaMapping"){

    def Up(xs: List[String]) = xs map {
      _.toUpperCase
    }

    Up(List("alejandra", "cadavid")) should be (List("ALEJANDRA","CADAVID"))

    def Low(xs: List[String], otherFunction: String => String) = xs map otherFunction

    Low(List("ALEJA","CADAVID"),{x => x.toLowerCase()}) should be (List("aleja","cadavid"))

    //using it inline
    val myName = (name: String) => s"My name is $name"

    Low(List("Aleja","Scala"),myName) should be (List("My name is Aleja","My name is Scala"))

    List("Scala", "Erlang", "Clojure") map (_.length) should be (List(5,6,7))


  }



}
