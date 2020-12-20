package ImageConversion

import Image.{CharPixel, RGBPixel}
import ImageConversion.Table.{ConversionTable, grayscaleTable}

class ConvertRGBtoChar(val grayScaleTable:ConversionTable = new grayscaleTable) extends Convert {

  def ConvertToChar(pixel: RGBPixel):CharPixel = {
    val gray = (0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)
    val index:Int = (gray / grayScaleTable.length).toInt
    val charRepresentation = grayScaleTable.getChar(index)
    return new CharPixel(charRepresentation)
  }
}
