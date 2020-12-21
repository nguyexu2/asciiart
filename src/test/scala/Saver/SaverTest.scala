package Saver

import Image.{CharPixel, Image, Pixel}
import Parameters._
import org.scalatest.FunSuite

import scala.io.Source

class SaverTest extends FunSuite {

  test("saving to file") {
    val image = new Image[CharPixel](Array(
      Array(new CharPixel('.'), new CharPixel('-')),
      Array(new CharPixel('.'), new CharPixel('%')),
      Array(new CharPixel('t'), new CharPixel(' ')),
    ))

    val saver = SaverFactory.get(List(new OutputLocation("src/test/output/x.txt")))
    saver(image)

    val source = Source.fromFile( "src/test/output/x.txt")
    val fileContents = source.mkString
    source.close()

    assert(fileContents == ".-\n.%\nt \n")
  }

  test("SaverFactory not implemented"){
    class myTestOutputParam_ extends OutputParam {}
    assertThrows[Throwable](SaverFactory.get(List(new myTestOutputParam_)))
  }

  test("many params"){

    val list = List(
      new InputLocation("sad_frog.jpg"),
      new FlipX, new Invert, new OutputConsole,
      new OutputConsole, new OutputLocation("src/test/output/x.txt"), new FlipX, new OutputConsole
    )

    val output = SaverFactory.get(list)
  }
}
