import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsOption extends FunSuite {

  test("TestSomeOption"){
    val someValue: Option[String] = Some("Hello")
    someValue should be (Some("Hello"))
  }

  test("TestNoneOption"){
    val emptyValue: Option[String] = None
    emptyValue should be (None)
  }

  def returnSomeThing(boolean: Boolean): Option[String] = {
    if (boolean) Some("Found Value") else None
  }

  // GetOrELse extrae el valor
  test("SomeAndNoneWithGetOrElse"){
    val value1 = returnSomeThing(true)
    value1 getOrElse "No value" should be ("Found Value")

    val value2 = returnSomeThing(false)
    value2 getOrElse "No value" should be ("No value")
    value2.getOrElse("No value") should be ("No value")

    value2 getOrElse {
      "default function"
    } should be ("default function")
  }

  //IsEmpty returns true is the option is None
  test("IsEmpty"){
    val value1 = returnSomeThing(true)
    val value2 = returnSomeThing(false) //Return None

    value1.isEmpty should be (false)
    value2.isEmpty should be (true)
  }


  //Pattern matching
  test("OptionWithMatch"){
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }

    value should be (20.0)

    val noValue: Option[Double] = None
    val value1 = noValue match {
      case Some(v) => v
      case None => 0.0
    }

    value1 should be (0.0)
  }

  // map apply the function in a Some. Return option. Also, transform types
  //_ anonymous
  test("OptionWithMap"){
    val number: Option[Int] = Some(3)
    val noNumber: Option[Int] = None

    val r1 = number.map(_*1.5)
    val r2 = noNumber.map(_*1.5)

    r1 should be (Some(4.5))
    r2 should be (None)
  }

  // Fold apply a binary operation
  test("OptionWithFold"){
    val num1: Option[Int] = Some(3)
    val num2: Option[Int] = None

    val r1 = num1.fold(1)(_*3)
    val r2 = num2.fold(1)(_*3)

    r1 should be (9)
    r2 should be (1) // Se ejecuta incluso cuando es None
  }

}
