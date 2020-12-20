package ImageConversion.Table

class BourkeTable extends ConversionTable {
  final val table: String = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "
  override def length: Int = table.length
  override def getChar(index: Int): Char = table(index)
}
