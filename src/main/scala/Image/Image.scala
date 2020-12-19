package Image

import java.awt.Color

class Image (val pixels: Array[Array[Color]]) {
  def getWidth() :Int = pixels(0).length
  def getHeight() :Int = pixels.length
}
