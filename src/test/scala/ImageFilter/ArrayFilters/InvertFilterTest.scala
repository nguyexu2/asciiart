package ImageFilter.ArrayFilters

import org.scalatest.FunSuite

class InvertFilterTest extends FunSuite{
  test("normal change") {
    val filter = new InvertFilter( (e:Int) => if(e >= 255) 0 else 255 -e)
    val input = Array(Array(255, 50), Array(60, 0))
    val output = filter.filter(input)

    input(0)(0) = -454054
    assert(output.length == input.length)
    assert(output(0).sameElements(Array(0, 255 -50)))
    assert(output(1).sameElements(Array(255-60, 255)))
  }

  test("type mismatch") {
    val filter = new InvertFilter( (e:Int) => e*50)
    val input = Array(Array("a", "b"))
    assertThrows[Throwable](filter.filter(input))
  }
}
