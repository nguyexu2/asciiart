import Loader.{FlipX, InputLocation, Invert, LoaderFactory, OutputConsole}
import org.scalatest.FunSuite

class LoaderTest extends FunSuite {
  test("empty"){
    val list = List()
    val factory = new LoaderFactory(list)
    assertThrows[IllegalArgumentException](factory.get())
  }

  test("no input available"){
    val list = List(
      new FlipX, new Invert, new OutputConsole
    )
    val factory = new LoaderFactory(list)
    assertThrows[IllegalArgumentException](factory.get())
  }

  test("normal input"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new FlipX, new Invert, new OutputConsole
    )
    val factory = new LoaderFactory(list)
    factory.get()
  }

  test("multiple inputs"){
    val list = List(
      new InputLocation("sad_frog.jpg"),
      new InputLocation("padoru.png"),
      new FlipX, new Invert, new OutputConsole
    )
    val factory = new LoaderFactory(list)
    factory.get()
  }
}
