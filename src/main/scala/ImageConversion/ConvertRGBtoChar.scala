package ImageConversion

import Image.{CharPixel, RGBPixel}
import ImageConversion.Table.{ConversionTable, grayscaleTable}

class ConvertRGBtoChar(val grayScaleTable:ConversionTable = new grayscaleTable) extends Convert {

    /*
  def ConvertToChar(pixels: Array[RGBPixel]) : Array[CharPixel] = {
    val ret = new Array[]()

  }
  */

  def ConvertToChar(red:Int, green:Int, blue:Int):CharPixel = {
    val gray = (0.3 * red) + (0.59 * green) + (0.11 * blue)
    val index:Int = (gray / grayScaleTable.length).toInt
    val charRepresentation = grayScaleTable.getChar(index)
    return new CharPixel(charRepresentation)
  }
}
