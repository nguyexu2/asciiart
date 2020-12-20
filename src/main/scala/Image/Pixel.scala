package Image

import java.awt.Color

abstract class Pixel {
}

class RGBPixel(val color: Color) extends Pixel {
  def red: Int = color.getRed
  def green: Int = color.getGreen
  def blue: Int = color.getBlue
}

class CharPixel(val char: Char) extends Pixel {
  override def toString: String = char.toString
}
