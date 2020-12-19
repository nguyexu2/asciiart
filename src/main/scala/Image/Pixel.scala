package Image

import java.awt.Color

abstract class Pixel {}

class RGBPixel(val color:Color) extends Pixel {}

class CharPixel(val char: Char) extends Pixel  {}
