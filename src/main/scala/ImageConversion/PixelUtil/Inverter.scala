package ImageConversion.PixelUtil

import ImageConversion.Table.ConversionTable

class Inverter(table:ConversionTable) {
  def apply(char:Char) : Char = {
    val value = table.findIndex(char)
    val invertedValue = table.length - 1 - value
    table.getChar(invertedValue)
  }
}
