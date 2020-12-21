package ImageFilter.ArrayFilters

import org.scalatest.FunSuite

class RotateTest extends FunSuite {
  test("0 rotation") {
    val rotator = new RotateFilter(0)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)
    assert(res.length == 2)
    assert(res(0).sameElements(Array(1, 2, 3)))
    assert(res(1).sameElements(Array(4, 5, 6)))
  }

  test("+90 rotation") {
    val rotator = new RotateFilter(90)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)
    assert(res.length == 3)
    assert(res(0).sameElements(Array(4, 1)))
    assert(res(1).sameElements(Array(5, 2)))
    assert(res(2).sameElements(Array(6, 3)))
  }

  test("+180 rotation") {
    val rotator = new RotateFilter(180)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)
    assert(res.length == 2)
    assert(res(0).sameElements(Array(6, 5, 4)))
    assert(res(1).sameElements(Array(3, 2, 1)))
  }

  test("-270 rotation") {
    val rotator = new RotateFilter(-270)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)
    assert(res.length == 3)
    assert(res(0).sameElements(Array(4, 1)))
    assert(res(1).sameElements(Array(5, 2)))
    assert(res(2).sameElements(Array(6, 3)))
  }

  test("over 720 rotation"){
    val rotator = new RotateFilter(720)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)
    assert(res.length == 2)
    assert(res(0).sameElements(Array(1, 2, 3)))
    assert(res(1).sameElements(Array(4, 5, 6)))
  }

  test("immutability test")
  {
    val rotator = new RotateFilter(180)
    val input = Array(Array(1, 2, 3), Array(4, 5, 6))
    val res = rotator.filter(input)

    input(0)(0) = 485151

    assert(res.length == 2)
    assert(res(0).sameElements(Array(6, 5, 4)))
    assert(res(1).sameElements(Array(3, 2, 1)))
  }

  test("not supported angle"){
    assertThrows[IllegalArgumentException](new RotateFilter(1))
  }

  test("not supported angle 2"){
    assertThrows[IllegalArgumentException](new RotateFilter(-456184))
  }
}
