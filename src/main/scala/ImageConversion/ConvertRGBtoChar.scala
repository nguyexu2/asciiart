package ImageConversion

import Image.{CharPixel, RGBPixel}

class ConvertRGBtoChar extends Convert {
  private final val grayScaleTable = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  def ConvertToChar(pixel: RGBPixel):CharPixel = {
    val gray = (0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)
    val index:Int = (gray / grayScaleTable.length).toInt
    val charRepresentation = grayScaleTable(index)
    return new CharPixel(charRepresentation)
  }
}
