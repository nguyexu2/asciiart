package ImageConversion.PixelUtil

import ImageConversion.Table.{BourkeTable, ConversionTable}

class ConvertRGBtoChar(val grayScaleTable:ConversionTable){
  def ConvertToChar(red:Int, green:Int, blue:Int):Char = {
    val gray = (0.3 * red) + (0.59 * green) + (0.11 * blue)
    val whitePercent = gray.toDouble / 255.0
    var index = (whitePercent * grayScaleTable.length).toInt
    if(index >= grayScaleTable.length )
      index = grayScaleTable.length - 1
    grayScaleTable.getChar(index)
  }
}
