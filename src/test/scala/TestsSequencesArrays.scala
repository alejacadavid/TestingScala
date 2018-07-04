import org.scalatest.FunSuite
import org.scalatest.Matchers._

class TestsSequencesArrays extends FunSuite{

  //Array : Same Type
  test("ListToArray"){
    val list = List(1,2,3)
    val array = list.toArray
    array should be (Array(1,2,3))

  }

  //Sequence: In order, iterable
  test("ArrayToSeq"){
    val array = Array(1,2,3)
    val seq = array.toSeq
    var list = seq.toList //Sequence to List
    list should be (List(1,2,3))
  }

  test("createSequence"){
    val seq = for(v<- 1 to 4) yield v
    seq.toList should be (List(1,2,3,4))

    val seq2 = for(v<- 1 to 10 if(v%3 ==0)) yield v
    seq2.toList should be (List(3,6,9))

  }

  test("filterSequence"){
    val seq = Seq("Hello", "World!!!!")

    val seqFilt = seq.filter(_.length>5)
    seqFilt should be (Seq("World!!!!"))
  }

  test("filterArray"){

    val array = Array("hello","again")
    val arrayFilt = array.filter(_.length>5)
    arrayFilt should be (Array())
  }

  test("mapWithSequences"){
    val seq = Seq("hello","world")
    val res = seq.map(_.reverse)
    res should be (Seq("olleh","dlrow"))


  }

}
