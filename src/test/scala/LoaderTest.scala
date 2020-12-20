import Loader.LoaderFactory
import Parameters.{FlipX, InputLocation, Invert, OutputConsole}
import org.scalatest.FunSuite

class LoaderTest extends FunSuite {
  test("empty"){
    val list = List()
    assertThrows[IllegalArgumentException](LoaderFactory.get(list))
  }

  test("no input available"){
    val list = List(
      new FlipX, new Invert, new OutputConsole
    )
    assertThrows[IllegalArgumentException](LoaderFactory.get(list))
  }

  test("normal input"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new FlipX, new Invert, new OutputConsole
    )
    LoaderFactory.get(list)
  }

  test("multiple inputs"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new InputLocation("padoru.png"),
      new FlipX, new Invert, new OutputConsole
    )
    LoaderFactory.get(list)
  }
}
