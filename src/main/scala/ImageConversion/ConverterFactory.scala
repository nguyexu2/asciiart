package ImageConversion

import Image.{CharPixel, Image, RGBPixel}
import ImageConversion.Table.ConvertRGBtoChar

object ConverterFactory {
  def RGBImageToCharImage: Image[RGBPixel] => Image[CharPixel] = {
    val table = new ConvertRGBtoChar

    val convertor = new ConvertImage[RGBPixel, CharPixel](
      (x: RGBPixel) => new CharPixel(table.ConvertToChar(x.red, x.green, x.blue))
    )

    x: Image[RGBPixel] => convertor.convert(x)
  }
}
