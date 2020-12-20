package ImageConversion

import Image.{CharPixel, RGBPixel}

class ConvertRGBtoChar extends Convert {
  private final val grayScaleTable = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  private def ConvertToChar(pixel: RGBPixel):CharPixel = {
    val gray = (0.3 * Red) + (0.59 * Green) + (0.11 * Blue))
  }
}
