import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsFormatting extends FunSuite{

  test("test1"){
    val s = "Hello World"
    "Application %s".format(s) should be("Application Hello World")

    val c = 'a' //unicode for a
    val d = '\141' //octal for a
    val f = '\\'

    "%c".format(c) should be("a")
    "%c".format(d) should be("a")
    "%c".format(f) should be("\\")

  }
}
