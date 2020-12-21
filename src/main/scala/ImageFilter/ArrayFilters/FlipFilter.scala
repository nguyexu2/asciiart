package ImageFilter.ArrayFilters

import scala.reflect.ClassTag

abstract class FlipFilter extends Filter {}

class FlipXFilter extends FlipFilter {
  /**
   * reverses array on the X axis
   * for each row: last element becomes 1st and the other way round
   */
  override def filter[T:ClassTag](arr: Array[Array[T]]): Array[Array[T]] =
    arr.map(_.reverse)
}

class FlipYFilter extends FlipFilter {
  /**
   * reverses array on the Y axis
   * 1st row will become last row and the other way round
   */
  override def filter[T:ClassTag](arr: Array[Array[T]]): Array[Array[T]] =
    arr.map(_.clone()).reverse
}