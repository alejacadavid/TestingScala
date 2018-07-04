import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsImplicits extends FunSuite{

  //Convierten tipo a otro tipo automaticamente
  test("t1"){

    class KoanIntWrapper(val original: Int) {
      def isOdd = original % 2 != 0
    }

    implicit def thisMethodNameIsIrrelevant(value: Int) =
      new KoanIntWrapper(value)

    19.isOdd should be(true)
    20.isOdd should be(false)

  }

  test("t1import"){
    object MyPredef {

      class KoanIntWrapper(val original: Int) {
        def isOdd = original % 2 != 0

        def isEven = !isOdd
      }

      implicit def thisMethodNameIsIrrelevant(value: Int) =
        new KoanIntWrapper(value)
    }

    import MyPredef._
    //imported implicits come into effect within this scope
    19.isOdd should be(true)
    20.isOdd should be(false)
  }

  test("t2"){
    import java.math.BigInteger
    implicit def Int2BigIntegerConvert(value: Int): BigInteger =
      new BigInteger(value.toString)

    def add(a: BigInteger, b: BigInteger) = a.add(b)

    add(Int2BigIntegerConvert(3), Int2BigIntegerConvert(6)) == Int2BigIntegerConvert(9) should be(true)


    add(3, 6) == 9 should be(false) //Retorna un BigInteger
    add(3, 6) == Int2BigIntegerConvert(9) should be(true)

    add(3, 6) == (9: BigInteger) should be(true)
    add(3, 6).intValue == 9 should be(true)
  }

  test("implicitValues"){
    def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
      dollarsPerHour * hours

    implicit val hourlyRate = BigDecimal(34)

    howMuchCanIMake_?(30)(hourlyRate) should be(1020)
    howMuchCanIMake_?(30) should be(1020)


  }

  test("implicitValues2"){

    def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
      (amount * hours).toString() + " " + currencyName

    implicit val hourlyRate = BigDecimal(34)
    implicit val currencyName = "Dollars"

    howMuchCanIMake_?(30) should be("1020 Dollars")
    howMuchCanIMake_?(30)(hourlyRate, currencyName) should be("1020 Dollars")


  }

  test("t3"){

    def howMuchCanIMake_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
      (amount * hours).toString() + " " + currencyName

    howMuchCanIMake_?(30) should be("1020 Dollars")

    howMuchCanIMake_?(30, 95,"Pesos") should be("2850 Pesos")
  }
}
