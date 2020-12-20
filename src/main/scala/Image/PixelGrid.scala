package Image

import scala.reflect.ClassTag

class PixelGrid[T <: Pixel :ClassTag](val array: Array[Array[T]]) {
  if (array.length == 0)
    throw new IllegalArgumentException("pixel grid has height of 0")

  if (array.exists(e => e.length == 0))
    throw new IllegalArgumentException("in pixel grid exists a row with width 0")

  val height:Int = array.length
  val width:Int = array(0).length

  def getPixel(x: Int, y: Int): T = {
    if (y > height - 1 || y < 0)
      throw new IllegalArgumentException()

    if (x > width - 1 || x < 0)
      throw new IllegalArgumentException()

    array(y)(x)
  }

  def getGrid : Array[Array[T]] = array.map(_.clone())
}