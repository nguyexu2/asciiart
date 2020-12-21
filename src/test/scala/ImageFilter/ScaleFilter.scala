package ImageFilter

import ImageFilter.ArrayFilters.{ScaleDownFilter, ScaleUpFilter}
import org.scalatest.FunSuite

class ScaleFilter extends FunSuite {
  test("no scaling") {
    val upFilter = new ScaleUpFilter(1)
    val input = Array(Array(0, 1), Array(5, -1))

    var output = upFilter.filter(input)
    assert(output.length == input.length)
    for ((a, b) <- input zip output) {
      assert(a.sameElements(b))
    }

    val downFilter = new ScaleDownFilter(1, (seq: Seq[Int]) => seq.head)

    output = downFilter.filter(input)
    assert(output.length == input.length)
    for ((a, b) <- input zip output) {
      assert(a.sameElements(b))
    }
  }

  test("make bigger") {
    val upFilter = new ScaleUpFilter(2)
    val input = Array(Array(0, 1), Array(5, -1))

    var output = upFilter.filter(input)
    assert(output.length == input.length * 2)
    assert(output(0).sameElements(Array(0, 0, 1, 1)))
    assert(output(1).sameElements(Array(0, 0, 1, 1)))
    assert(output(2).sameElements(Array(5, 5, -1, -1)))
    assert(output(3).sameElements(Array(5, 5, -1, -1)))
  }

  test("make smaller") {
    val downFilter = new ScaleDownFilter(0.5, (seq: Seq[Int]) => seq.sum / seq.length)
    val input = Array(
      Array(0, 0, 1, 1),
      Array(0, 0, 1, 1),
      Array(5, 5, -1, -1),
      Array(5, 5, -1, -1))

    var output = downFilter.filter(input)
    assert(output.length * 2 == input.length)
    assert(output(0).sameElements(Array(0, 1)))
    assert(output(1).sameElements(Array(5, -1)))
  }

  test("illegal values") {
    assertThrows[Throwable](new ScaleDownFilter(5, (seq: Seq[Int]) => seq.sum / seq.length))
    assertThrows[Throwable](new ScaleUpFilter(0))

  }

  test("not rectangular input") {
    val input = Array(
      Array(0, 0, 1),
      Array(0, 0, 1, 1),
      Array(5, 5, -1, -1),
      Array(5, 5, -1, -1))

    val up = new ScaleUpFilter(5)
    val down = new ScaleDownFilter(0.5, (seq: Seq[Int]) => seq.sum / seq.length)
    assertThrows[Throwable](up.filter(input))
    assertThrows[Throwable](down.filter(input))
  }
}
