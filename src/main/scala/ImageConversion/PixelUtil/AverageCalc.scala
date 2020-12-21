package ImageConversion.PixelUtil

import ImageConversion.Table.ConversionTable

class AverageCalc(table: ConversionTable) {
  def apply(seq: Seq[Char]):Char = {
    val average = seq.map( (x:Char) => table.findIndex(x)).sum / seq.length
    table.getChar(average)
  }
}
