import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsTraversables extends FunSuite{
//Traversables are the superclass of List, Array, Map, Set, Stream and more


  test("++"){
    //The resulting Traversable is the same type of the first element.
    val set = Set(1, 9, 10, 22)
    val list = List(3, 4, 5, 10)
    val result = set ++ list
    result.size should be(8)
    result should be (Set(1,9,10,22,3,4,5,10))

    val result2 = list ++ set
    result2.size should be(8)

  }
}
