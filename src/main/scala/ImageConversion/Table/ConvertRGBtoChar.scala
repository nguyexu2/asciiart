package ImageConversion.Table

class ConvertRGBtoChar(val grayScaleTable:ConversionTable = new BourkeTable){
  def ConvertToChar(red:Int, green:Int, blue:Int):Char = {
    val gray = (0.3 * red) + (0.59 * green) + (0.11 * blue)
    val blackPercent = gray.toDouble / 255.0
    var index = (blackPercent * grayScaleTable.length).toInt
    if(index >= grayScaleTable.length )
      index = grayScaleTable.length - 1
    grayScaleTable.getChar(index)
  }
}
