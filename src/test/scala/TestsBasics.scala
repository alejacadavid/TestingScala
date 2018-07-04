import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsBasics extends FunSuite {

  test("TestBasic") {
    assert(1 == 1) //No muestra mensaje del error
  }

  test("TestBasic2") {
    val left = 2
    val right = 2
    assert(left==right) //Genera mensaje del error
  }

  test("TestWithShould") {
    val result = 2 + 1
    result should equal(3) // can customize equality
    result should ===(3) // can customize equality and enforce type constraints
    result should be(3) // cannot customize equality, so fastest to compile
    result shouldEqual 3 // can customize equality, no parentheses required
    result shouldBe 3       // cannot customize equality, so fastest to compile, no parentheses required
  }


}