package ImageConversion

import ImageConversion.PixelUtil._
import ImageConversion.Table.ConversionTable
import org.scalatest.FunSuite

class utilTest extends FunSuite {
  object myTable extends ConversionTable {
    override def length: Int = "0123456789".length

    override def getChar(index: Int): Char = "0123456789"(index)

    override def findIndex(char: Char): Int = "0123456789".indexOf(char.toString)
  }

  test("average") {
    val calc = new AverageCalc(myTable)
    assert(calc.apply(List()) == '0')
    val middle = calc.apply(List('0', '9'))
    assert(middle == '4' || middle == '5')

    assert(calc.apply(List('0', '9', middle)) == middle)

    assert(calc.apply(List('0', middle, '9')) == calc.apply(List('0', '9', middle)))
  }

  test("change brightness") {
    var calc = new ChangeBrightness(myTable, 0)
    assert(calc.apply('0') == '0')
    assert(calc.apply('5') == '5')

    calc = new ChangeBrightness(myTable, 10)
    assert("01".contains(calc.apply('0')))
    assert("56".contains(calc.apply('5')))

    calc = new ChangeBrightness(myTable, -10)
    assert("0".contains(calc.apply('0')))
    assert("45".contains(calc.apply('5')))

    calc = new ChangeBrightness(myTable, 456789456)
    assert(calc.apply('0') == calc.apply('8'))
    assert(calc.apply('0') == '9')

    calc = new ChangeBrightness(myTable, -456789456)
    assert(calc.apply('0') == calc.apply('8'))
    assert(calc.apply('0') == '0')
  }

  test("rgb to char"){
    val converter = new ConvertRGBtoChar(myTable)
    assert(converter.convertToChar(0, 0, 0) == '0')
    assert(converter.convertToChar(255, 255, 254) == '9')
  }

  test("invert"){
    val inverter = new Inverter(myTable)
    assert(inverter.apply('0') == '9')
    assert(inverter.apply('9') == '0')
    assert(inverter.apply('1') == '8')
    assert(inverter.apply('5') == '4')
  }
}
