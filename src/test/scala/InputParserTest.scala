import org.scalatest.FunSuite
import Loader.InputParser

class InputParserTest extends FunSuite {
  test("empty"){
    val parser = new InputParser(new Array[String](0))
    assert(parser.Parse().isEmpty)
  }

  test("illegal argument")
  {
    val input = new Array[String](2)
    input(0) = "test"
    val parser = new InputParser(input)
    assertThrows[IllegalArgumentException](parser.Parse())
  }

  test("invalid flip")
  {
    val input = new Array[String](2)
    input(0) = "--flip"
    input(1) = "a"
    val parser = new InputParser(input)
    assertThrows[IllegalArgumentException](parser.Parse())
  }
}
