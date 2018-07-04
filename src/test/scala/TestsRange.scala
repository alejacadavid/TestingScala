import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsRange extends FunSuite{

  test("test1"){
    val someNumbers = Range(0, 10) // 0,1,2,3,4,5,6,7,8,9
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(10)
    second should be(1)
    last should be(9)

    val otherRange = 0 until 10

    (someNumbers == otherRange) should be(true)


  }

  test("test2"){

    val someNumbers = Range(2, 10, 3) //2,5,8
    val second = someNumbers(1)
    val last = someNumbers.last

    someNumbers.size should be(3)
    second should be(5)
    last should be(8)

    val someNumbers2 = Range(2, 8, 3) //2,5
    someNumbers2.last should be (5)
    someNumbers2.size should be (2)


    val someNumbers3 = Range(2, 8, 3).inclusive //2,5,8
    someNumbers3.last should be (8)
    someNumbers3.size should be (3)
  }
}
