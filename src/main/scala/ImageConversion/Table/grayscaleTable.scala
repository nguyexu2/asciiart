package ImageConversion.Table

class grayscaleTable(val table: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ") extends ConversionTable {
  override def length: Int = table.length
  override def getChar(index: Int): Char = table(index)
}
