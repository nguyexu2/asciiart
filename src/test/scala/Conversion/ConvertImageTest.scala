package Conversion

import Image.{Image, Pixel}
import ImageConversion.ConvertImage
import org.scalatest.FunSuite

class ConvertImageTest extends FunSuite {

  class myPixel(val int: Int) extends Pixel

  test("identity") {
    val convert = new ConvertImage[myPixel, myPixel]((e: myPixel) => e: myPixel)
    val input = new Image(Array(
      Array(new myPixel(1), new myPixel(2)),
      Array(new myPixel(3), new myPixel(4)),
      Array(new myPixel(5), new myPixel(6)),
    ))

    val output: Image[myPixel] = convert.convert(input)

    val inGrid = input.getGrid
    val outGrid = output.getGrid

    for (i <- 0 until 3; j <- 0 until 2)
      assert(inGrid(i)(j).int == outGrid(i)(j).int)
  }

  test("modifying data") {
    val convert = new ConvertImage[myPixel, myPixel]((e: myPixel) => new myPixel(e.int * 10))
    val input = new Image(Array(
      Array(new myPixel(1), new myPixel(2)),
      Array(new myPixel(3), new myPixel(4)),
      Array(new myPixel(5), new myPixel(6)),
    ))

    val output: Image[myPixel] = convert.convert(input)

    val inGrid = input.getGrid
    val outGrid = output.getGrid

    for (i <- 0 until 3; j <- 0 until 2)
      assert(inGrid(i)(j).int * 10 == outGrid(i)(j).int)
  }
}
