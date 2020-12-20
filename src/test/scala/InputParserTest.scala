import org.scalatest.FunSuite
import Loader.InputParser
import Parameters.{Brightness, FlipX, FlipY, InputLocation, Invert, OutputConsole, OutputLocation, Rotate, Scale}

class InputParserTest extends FunSuite {
  test("empty") {
    val parser = new InputParser(new Array[String](0))
    assert(parser.Parse().isEmpty)
  }

  test("illegal argument") {
    val input = Array[String]("test")
    val parser = new InputParser(input)
    assertThrows[IllegalArgumentException](parser.Parse())
  }

  test("invalid flip") {
    val input = Array[String]("--flip", "a")
    val parser = new InputParser(input)
    assertThrows[IllegalArgumentException](parser.Parse())
  }

  test("valid flip") {
    val input = Array[String]("--flip", "x", "--flip", "y")
    val ret = new InputParser(input).Parse()
    assert(ret.length == 2 && ret(0).isInstanceOf[FlipX] && ret(1).isInstanceOf[FlipY])
  }


  test("valid minimal input") {
    val input = Array[String]("--image", "sad_frog.jpg", "--output-console")
    val ret = new InputParser(input).Parse()
    assert(ret.length == 2 && ret(0).isInstanceOf[InputLocation] && ret(1).isInstanceOf[OutputConsole])
  }

  test("all available params at once") {
    val input = Array[String]("--image", "sad_frog.jpg",
      "--flip", "x",
      "--flip", "y",
      "--invert",
      "--rotate", "+15",
      "--rotate", "-15",
      "--scale", "0.25",
      "--brightness", "+60",
      "--output-file", "../outputs/output.txt")
    val ret = new InputParser(input).Parse()
    assert(ret.length == 9)
    assert(ret(0).isInstanceOf[InputLocation])
    assert(ret(1).isInstanceOf[FlipX])
    assert(ret(2).isInstanceOf[FlipY])
    assert(ret(3).isInstanceOf[Invert])
    assert(ret(4).isInstanceOf[Rotate] && ret(4).asInstanceOf[Rotate].degree == 15)
    assert(ret(5).isInstanceOf[Rotate] && ret(5).asInstanceOf[Rotate].degree == -15)
    assert(ret(6).isInstanceOf[Scale] && ret(6).asInstanceOf[Scale].value == 0.25)
    assert(ret(7).isInstanceOf[Brightness] && ret(7).asInstanceOf[Brightness].value == 60)
    assert(ret(8).isInstanceOf[OutputLocation] && ret(8).asInstanceOf[OutputLocation].path == "../outputs/output.txt")
  }
}
