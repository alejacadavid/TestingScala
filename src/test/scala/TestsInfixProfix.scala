import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsInfixProfix extends FunSuite{

  // Any method which takes a single parameter can be used as an infix operator
  test("t1"){
    val g: Int = 3
    (g+4) should be (7)
    g.+(4) should be (7)

  }

  test("t2"){

    val g = "Hello World"

    g indexOf 'o' should be (4)
    g.indexOf('o',5) should be (7)
  }

  //Any method which does not require a parameter can be used as a postfix operator
  test("t3"){

    val g = 31
    (g.toHexString) should be ("1f")

    (g toHexString) should be ("1f")
  }


  //INFIX TYPES
  //T1 op T2  == op[T1,T2]


  case class Person(name: String) {
    def loves(person: Person) = new Loves(this, person)
  }

  class Loves[A, B](val a: A, val b: B)

  test("infixTypes"){

    def announceCouple(couple: Person Loves Person) =
    //Notice our type: Person loves Person!
      couple.a.name + " is in love with " + couple.b.name

    val romeo = new Person("Romeo")
    val juliet = new Person("Juliet")

    announceCouple(romeo loves juliet) should be("Romeo is in love with Juliet")

  }
}
