package ImageFilter.ArrayFilters

import ImageFilter.Filter

import scala.reflect.ClassTag

abstract class FlipFilter extends Filter {}

class FlipXFilter extends FlipFilter {
  override def filter[T:ClassTag](arr: Array[Array[T]]): Array[Array[T]] =
    arr.map(_.reverse)
}

class FlipYFilter extends FlipFilter {
  override def filter[T:ClassTag](arr: Array[Array[T]]): Array[Array[T]] =
    arr.map(_.clone()).reverse
}