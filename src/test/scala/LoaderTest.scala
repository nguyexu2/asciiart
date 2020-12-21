import Loader.LoaderFactory
import Parameters.{FlipX, InputLocation, Invert, OutputConsole}
import org.scalatest.FunSuite

class LoaderTest extends FunSuite {
  test("empty"){
    val list = List()
    assert(LoaderFactory.get(list).isEmpty)
  }

  test("no input available"){
    val list = List(
      new FlipX, new Invert, new OutputConsole
    )
    assert(LoaderFactory.get(list).isEmpty)
  }

  test("normal input"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new FlipX, new Invert, new OutputConsole
    )
    assert(LoaderFactory.get(list).isDefined)
  }

  test("multiple inputs"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new InputLocation("padoru.png"),
      new FlipX, new Invert, new OutputConsole
    )
    assert(LoaderFactory.get(list).isDefined)
  }
}
