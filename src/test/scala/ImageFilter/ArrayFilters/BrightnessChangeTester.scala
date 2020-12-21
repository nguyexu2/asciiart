package ImageFilter.ArrayFilters

import org.scalatest.FunSuite

class BrightnessChangeTester extends FunSuite {
  test("empty input"){
    val filter = new ChangeBrightnessFilter( (e:Int) => e*50)
    val input = Array(Array[Int]())
    assert(filter.filter(input).length == 1)
  }

  test("no brightness change") {
    val filter = new ChangeBrightnessFilter( (e:Int) => e)
    val input = Array(Array(0, 1), Array(5, -1))
    val output = filter.filter(input)

    assert(output.length == input.length)
    assert(output(0).sameElements(Array(0, 1)))
    assert(output(1).sameElements(Array(5, -1)))
  }

  test("immutability") {
    val filter = new ChangeBrightnessFilter( (e:Int) => e*50)
    val input = Array(Array(0, 1), Array(5, -1))
    val output = filter.filter(input)

    input(0)(0) = -454054
    assert(output.length == input.length)
    assert(output(0).sameElements(Array(0, 50)))
    assert(output(1).sameElements(Array(250, -50)))
  }

  test("type mismatch") {
    val filter = new ChangeBrightnessFilter( (e:Int) => e*50)
    val input = Array(Array("a", "b"))
    assertThrows[Throwable](filter.filter(input))
  }

}
