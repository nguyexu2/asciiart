package Filters

import ImageFilter.{FlipXFilter, FlipYFilter}
import org.scalatest.FunSuite

class FlipTester extends FunSuite {
  test("flip Y") {
    val input = Array(Array(0, 1),
                      Array(2, 3))
    val res = new FlipYFilter().filter(input)
    assert(input.length == res.length)
    assert(res(0).sameElements(Array(2, 3)))
    assert(res(1).sameElements(Array(0, 1)))
  }

  test("flip Y 1 elem") {
    val input = Array(Array(5))
    val res = new FlipYFilter().filter(input)
    assert(input.length == res.length)
    assert(res(0).sameElements(input(0)))
  }

  test("flip Y immutability") {
    val input = Array(Array(0, 1), Array(2, 3))
    val res = new FlipYFilter().filter(input)
    input(0) = Array(5, 6)
    input(1)(1) = 94
    assert( res.length == 2)
    assert(res(0).sameElements(Array(2, 3)))
    assert(res(1).sameElements(Array(0, 1)))
  }

  test("flip X") {
    val input = Array(Array(0, 1),
                      Array(2, 3),
                      Array(4, 5),
    )
    val res = new FlipXFilter().filter(input)
    assert(input.length == res.length)
    assert(res(0).sameElements(Array(1, 0)))
    assert(res(1).sameElements(Array(3, 2)))
    assert(res(2).sameElements(Array(5, 4)))
  }

  test("flip X 1 elem") {
    val input = Array(Array(5))
    val res = new FlipXFilter().filter(input)
    assert(input.length == res.length)
    assert(res(0).sameElements(input(0)))
  }

  test("flip X immutability") {
    val input = Array(Array(0, 1), Array(2, 3))
    val res = new FlipXFilter().filter(input)
    input(0) = Array(5, 6)
    input(1)(1) = 94
    assert( res.length == 2)
    assert(res(0).sameElements(Array(1, 0)))
    assert(res(1).sameElements(Array(3, 2)))
  }

}
