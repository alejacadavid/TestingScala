import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsPartialFunction extends FunSuite{


  //PartialFunction
  //isDefinedAt: condition
  //apply: task
  test("t1"){
    val doubleEvens: PartialFunction[Int, Int] =
      new PartialFunction[Int, Int] {
        //States that this partial function will take on the task
        def isDefinedAt(x: Int) = x % 2 == 0

        //What we do if this partial function matches
        def apply(v1: Int) = v1 * 2
      }


    val tripleOdds: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
      def isDefinedAt(x: Int) = x % 2 != 0

      def apply(v1: Int) = v1 * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together

    whatToDo(3) should be(9) // 3%2 != 0 --> apply TripleOdss
    whatToDo(2) should be(4) //2%2 == 0 ---> apply doubleEvens

  }

  test("t1Automatic"){
    val doubleEvens: PartialFunction[Int, Int] = {
      case x if (x % 2) == 0 ⇒ x * 2
    }
    val tripleOdds: PartialFunction[Int, Int] = {
      case x if (x % 2) != 0 ⇒ x * 3
    }

    val whatToDo = doubleEvens orElse tripleOdds //Here we chain the partial functions together
    whatToDo(3) should be(9)
    whatToDo(4) should be(8)


    //andThen... Siempre lo ejecuta
    //orElse ... ejecuta el primero, si este no cumple, ejecuta el segundo
    val addFive = (x: Int) ⇒ x + 5
    val whatToDo1 = doubleEvens orElse tripleOdds andThen addFive //Here we chain the partial functions together
    whatToDo1(3) should be(14)
    whatToDo1(4) should be(13)

  }


  test("t3"){

    val pares: PartialFunction[Int, Int] = {
      case x if (x%2) == 0 => x*2
    }

    val impar: PartialFunction[Int, Int] = {
      case x if (x%2) != 0 => x*3
    }

    val impPar: PartialFunction[Int, String] = {
      case x if (x%2) == 0 => "Even"
    }

    val impImpar: PartialFunction[Int, String] = {
      case x if (x%2) != 0 => "Odd"
    }

    val queHacer = pares orElse impar andThen(impPar orElse impImpar)

    queHacer(5) should be ("Odd")
    queHacer(2) should be("Even")

  }
}
