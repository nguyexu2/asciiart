package Image

class GridImage(pixelGrid: PixelGrid[_]) extends Image {
  val width = pixelGrid.width
  val height = pixelGrid.height

  def getPixel(x: Int, y: Int) = pixelGrid.getPixel(x, y)
}

class PixelGrid[T <: Pixel](array: Array[Array[T]]) {
  if (array.length == 0)
    throw new IllegalArgumentException("pixel grid has height of 0")

  if (array.exists(e => e.length == 0))
    throw new IllegalArgumentException("in pixel grid exists a row with width 0")

  val height = array.length
  val width = array(0).length

  def getPixel(x: Int, y: Int): T = {
    if (y > height - 1 || y < 0)
      throw new IllegalArgumentException();

    if (x > width - 1 || x < 0)
      throw new IllegalArgumentException();

    array(y)(x)
  }
}
