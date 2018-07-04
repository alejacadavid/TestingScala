import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsObjects extends FunSuite {


  object Greeting{
    def eng = "Hello"
    def spa = "Hola"
  }

  test("TestObjects1"){
    Greeting.eng should be ("Hello")
    Greeting.spa should be ("Hola")

  }


}
