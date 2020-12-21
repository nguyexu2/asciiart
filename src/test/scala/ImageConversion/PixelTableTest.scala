package ImageConversion

import ImageConversion.PixelUtil.ConvertRGBtoChar
import ImageConversion.Table.BourkeTable
import org.scalatest.FunSuite

class PixelTableTest extends FunSuite {
  test("convert white") {
    val table = new BourkeTable
    val convertor = new ConvertRGBtoChar(table)
    assert(convertor.convertToChar(255, 255, 255) == table.getChar(table.length - 1))
  }

  test("convert black") {
    val table = new BourkeTable
    val convertor = new ConvertRGBtoChar(table)
    assert(convertor.convertToChar(0, 0, 0) == table.getChar(0))
  }

  test("Pixel") {
    val table = new BourkeTable
    val convertor = new ConvertRGBtoChar(table)
    val res = convertor.convertToChar(100, 100, 100)
    assert("CJU".contains(res))
  }

  test("near black") {
    val table = new BourkeTable
    val convertor = new ConvertRGBtoChar(table)
    val res = convertor.convertToChar(255, 253, 254)
    assert(". ".contains(res))
  }

  test("find Index") {
    val table = new BourkeTable
    assert(table.length - 1 == table.findIndex(' '))
    assert(0 == table.findIndex('$'))
  }

}
