package ImageConversion

import Image.{CharPixel, Image, RGBPixel}
import ImageConversion.Table.{BourkeTable, ConvertRGBtoChar}
import ImageConversion.Table.PixelUtil.Inverter

object ConverterFactory {
  def RGBImageToCharImage: Image[RGBPixel] => Image[CharPixel] = {
    val table = new ConvertRGBtoChar(new BourkeTable)

    val convertor = new ConvertImage[RGBPixel, CharPixel](
      (x: RGBPixel) => new CharPixel(table.ConvertToChar(x.red, x.green, x.blue))
    )

    x: Image[RGBPixel] => convertor.convert(x)
  }

  def CharInverter: CharPixel => CharPixel = {
    val inverter = new Inverter(new BourkeTable)
    (a:CharPixel) => new CharPixel(inverter.apply(a.char))
  }
}
