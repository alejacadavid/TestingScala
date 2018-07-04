import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsMaps extends FunSuite {

  test("Maps1"){
    val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

    val mapValues = myMap.values
    mapValues.size should be(3)
    mapValues.head should be("Michigan") //Failed presumption: The order in maps is not guaranteed

    val lastElement = mapValues.last
    lastElement should be("Wisconsin")

    myMap("MI") should be("Michigan")
  }

  test("GetOrElse"){

    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    intercept[NoSuchElementException] {
      myMap("TX")
    }
    myMap.getOrElse("TX", "missing data") should be("missing data")

    val myMap2 = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa") withDefaultValue "missing data"
    myMap2("TX") should be("missing data")
  }

  test("remove"){

    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - ("MI", "WI") // Notice: single '-' operator for tuples

    aNewMap.contains("MI") should be(false)
    myMap.contains("MI") should be(true)
    aNewMap.contains("OH") should be(true)
    aNewMap.size should be(2)
    myMap.size should be(4)
  }

  test("equals"){

    val myMap =
      Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "IA" → "Iowa")
    val aNewMap = myMap - "MN"

    aNewMap.equals(myMap) should be(true)
  }
}
