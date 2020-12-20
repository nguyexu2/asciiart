package Image

import java.awt.Color

abstract class Pixel {}

class RGBPixel(val color:Color) extends Pixel {
  val red = color.getRed()
  val green = color.getGreen()
  val blue = color.getBlue()
}

class CharPixel(val char: Char) extends Pixel  {}
