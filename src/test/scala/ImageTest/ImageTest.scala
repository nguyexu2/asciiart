package ImageTest

import Image.{Image, Pixel}
import org.scalatest.FunSuite

class ImageTest extends FunSuite{
  test("small input"){
    class tmp(val int:Int) extends Pixel{}
    val input = Array(Array(new tmp(1), new tmp(2), new tmp(3)),
      Array(new tmp(1), new tmp(2), new tmp(6)))
    val img = new Image[tmp](input)

    assert(img.width == 3)
    assert(img.height == 2)
    assert(img.getPixel(0, 0).int == 1)
    assert(img.getPixel(1, 0).int == 2)
    assert(img.getPixel(2, 1).int == 6)

    assertThrows[Throwable](img.getPixel(3, 0) )
  }

  test("grid testing"){
    class tmp(val int:Int) extends Pixel{}
    val input = Array(Array(new tmp(1), new tmp(2), new tmp(3)),
      Array(new tmp(1), new tmp(2), new tmp(6)))
    val img = new Image[tmp](input)

    val grid = img.getGrid
    assert(grid(0)(0).int == input(0)(0).int)
    assert(grid(1)(2).int == input(1)(2).int)
  }
}
