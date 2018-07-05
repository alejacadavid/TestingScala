import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsSets extends FunSuite {

  //Sets are Iterables that contain no duplicate elements.
  //can't have duplicate elements.
  //Sets are traditionally unordered

  test("contains"){

    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    mySet.size should be(4)


    val mySet2 = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
    mySet2.size should be(3)

    val aNewSet = mySet + "Illinois"
    aNewSet.contains("Illinois") should be(true)

    val aNewSet2 = mySet - "Michigan"
    aNewSet2.contains("Michigan") should be(false)
  }

  test("diff"){

    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan")
    val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want to.

    aNewSet.equals(Set("Ohio", "Iowa")) should be(true)
    aNewSet.equals(Set("Iowa","Ohio")) should be (true)
  }

  test("head"){
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    mySet1.head should be ("Michigan")
  }

  test("tail"){
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    mySet1.tail should be (Set("Ohio","Wisconsin","Iowa"))

  }

}
