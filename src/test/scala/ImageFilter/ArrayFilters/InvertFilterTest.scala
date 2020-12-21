package ImageFilter.ArrayFilters

import org.scalatest.FunSuite

class InvertFilterTest extends FunSuite{

  test("normal change") {
    val filter = new InvertFilter( (e:Int) => 255 -e)
    val input = Array(Array(255, 50), Array(60, 0))
    val output = filter.filter(input)

    assert(output.length == input.length)
    assert(output(0).sameElements(Array(0, 255 -50)))
    assert(output(1).sameElements(Array(255-60, 255)))
  }

  test("type mismatch") {
    val filter = new InvertFilter( (e:Int) => e*50)
    val input = Array(Array("a", "b"))
    assertThrows[Throwable](filter.filter(input))
  }

  test("empty input"){
    val filter = new InvertFilter( (e:Int) => 255 -e)
    val input = Array(Array[Int]())
    val output = filter.filter(input)
    assert(output.length == 1 && output(0).length == 0)
  }

  test("immutability"){
    val filter = new InvertFilter( (e:Int) => 255 -e)
    val input = Array(Array(255, 50), Array(60, 0), Array(200, 100))
    val output = filter.filter(input)

    input(0)(0) = -454054
    assert(output.length == input.length)
    assert(output(0).sameElements(Array(0, 255 -50)))
    assert(output(1).sameElements(Array(255-60, 255)))
    assert(output(2).sameElements(Array(255-200, 255-100)))
  }
}
