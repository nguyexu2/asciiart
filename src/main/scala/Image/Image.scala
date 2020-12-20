package Image

import scala.reflect.ClassTag

class Image[T <: Pixel:ClassTag](pixelGrid: PixelGrid[T]) {
  def this(array: Array[Array[T]]) = this(new PixelGrid[T](array))

  val width :Int= pixelGrid.width
  val height:Int = pixelGrid.height

  def getPixel(x: Int, y: Int):T = pixelGrid.getPixel(x, y)

  def getGrid:Array[Array[T]] = pixelGrid.getGrid
}

