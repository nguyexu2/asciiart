package ImageConversion.PixelUtil

import Image.CharPixel
import ImageConversion.Table.ConversionTable

class ChangeBrightness(table: ConversionTable, offset: Int) {
  def apply(char: Char): Char = {
    //convert from char to range0-255
    val index = table.findIndex(char)
    val whitePercent = index.toDouble / table.length.toDouble
    val gray = whitePercent * 255

    //saturated addition with offset
    var newGray = if (gray + offset > 255) 255
    else if (gray + offset < 0) 0
    else gray + offset

    //convert back down to char
    val newWhitePercent = newGray/255.0
    var newIndex = (whitePercent * table.length).toInt
    if(newIndex >= table.length )
      newIndex = table.length - 1
    table.getChar(newIndex)
  }
}
