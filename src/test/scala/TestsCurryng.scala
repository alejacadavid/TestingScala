import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsCurryng extends FunSuite{
  test("t1"){
    def multiply(x: Int, y: Int) = x * y
    (multiply _).isInstanceOf[Function2[_, _, _]] should be(true)


    val multiplyCurried = (multiply _).curried //Define una funcion con cada uno de los parámetro. UNa funcion por parámetro
    multiply(4, 5) should be(20)
    multiplyCurried(3)(2) should be(6)
    val multiplyCurriedFour = multiplyCurried(4)
    multiplyCurriedFour(2) should be(8)
    multiplyCurriedFour(4) should be(16)

  }

  test("t2"){
    def customFilter(f: Int ⇒ Boolean)(xs: List[Int]) =
      xs filter f
    def onlyEven(x: Int) = x % 2 == 0
    val xs = List(12, 11, 5, 20, 3, 13, 2)
    customFilter(onlyEven)(xs) should be(List(12,20,2))

    val onlyEvenFilter = customFilter(onlyEven) _ //FUncion particionada
    onlyEvenFilter(xs) should be(List(12,20,2))
  }

}
