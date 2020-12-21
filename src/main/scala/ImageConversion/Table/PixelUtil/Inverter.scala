package ImageConversion.Table.PixelUtil

import Image.CharPixel
import ImageConversion.Table.ConversionTable

class Inverter(table:ConversionTable) {
  def apply(pixel: CharPixel) : CharPixel = {
    val value = table.findIndex(pixel.char)
    val invertedValue = table.length - value
    new CharPixel(table.getChar(invertedValue))
  }
}
