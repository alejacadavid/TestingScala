import org.scalatest.FunSuite
import org.scalatest.Matchers._

// It's like interfaces of Java
// It doesn't have parameters of constructor
// Can be partially implemented
class TestsTrait extends FunSuite{

  test("t1"){

    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") ⇒
            "An unfortunate moose stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val evt = Event("Moose Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be("An unfortunate moose stampede occurred")

    val evt1 = Event("Other event")

    val myListener1 = new MyListener
    myListener1.listen(evt1) should be ("Nothing of importance occurred")
  }

  test("t3"){

    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class OurListener

    class MyListener extends OurListener with EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Woodchuck Stampede") ⇒
            "An unfortunate woodchuck stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val evt = Event("Woodchuck Stampede")
    val myListener = new MyListener
    myListener.listen(evt) should be( "An unfortunate woodchuck stampede occurred")
  }

  test("t4"){
    case class Event(name: String)

    trait EventListener {
      def listen(event: Event): String
    }

    class MyListener extends EventListener {
      def listen(event: Event): String = {
        event match {
          case Event("Moose Stampede") ⇒
            "An unfortunate moose stampede occurred"
          case _ ⇒ "Nothing of importance occurred"
        }
      }
    }

    val myListener = new MyListener

    myListener.isInstanceOf[MyListener] should be(true)
    myListener.isInstanceOf[EventListener] should be(true)
    myListener.isInstanceOf[Any] should be(true)
    myListener.isInstanceOf[AnyRef] should be(true)


  }


  //Any is the supertype of all types
  // It defines certain universal methods such as equals, hashCode, and toString
  trait Similarity{
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }

  class Point(xc: Int, yc: Int) extends Similarity{
    var x:Int = xc
    var y:Int = yc

    def isSimilar(obj: Any) =
      obj.isInstanceOf[Point] &&
        obj.asInstanceOf[Point].x == x
  }

  test("testTrait"){
    val p1 = new Point(2,2)
    val p2 = new Point(3,3)
    val p3 = new Point(4,2)
    val p4 = new Point(4,4)

    p1.isSimilar(p3) should be (false)
    p2.isNotSimilar(p1) should be (true)
    p2.isNotSimilar(p3) should be (true)
    p3.isSimilar(p4) should be (true)

  }

}
