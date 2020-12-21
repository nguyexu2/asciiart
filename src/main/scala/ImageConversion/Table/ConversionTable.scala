package ImageConversion.Table

abstract class ConversionTable {
  def length: Int
  def getChar(index: Int): Char
  def findIndex(char: Char):Int
}


