import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsTuples extends FunSuite{

  test("TupleBasic"){
    val t = (1, "Alejandra", 23)

    t._1 should be (1)
    t._2 should be ("Alejandra")
    t._3 should be (23)
  }

  test("TupleBasic2"){
    val person = ("Alejandra",23,2)
    val (name, age, num) = person

    name should be ("Alejandra")
    age should be (23)
    num should be (2)

  }

  //Swap intercambiar - Only Tuple2
  test("TupleWithSwap"){
    val person = ("Alejandra",23).swap

    person._1 should be (23)
    person._2 should be ("Alejandra")



  }

}
