package ImageConversion

import Image.{CharPixel, Image, RGBPixel}
import ImageConversion.Table.BourkeTable
import ImageConversion.PixelUtil.{AverageCalc, ChangeBrightness, ConvertRGBtoChar, Inverter}

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

  def ChangeBrightness(value: Int): CharPixel => CharPixel = {
    val util = new ChangeBrightness(new BourkeTable, value)
    (a:CharPixel) => new CharPixel(util.apply(a.char))
  }

  def Average: Seq[CharPixel] => CharPixel = {
    val util = new AverageCalc(new BourkeTable)
    (seq: Seq[CharPixel]) => new CharPixel(util.apply(seq.map(x => x.char)))
  }
}
