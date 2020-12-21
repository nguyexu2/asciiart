package ImageFilter.ArrayFilters

import scala.reflect.ClassTag

class InvertFilter[A](invert: A => A) extends Filter{
  /**
   * @param arr input that method will be apply function on
   * @tparam T type of array AND function passed in ctor, make sure they're the same, else an exception will be thrown
   * @return modified array
   */
  override def filter[T:ClassTag](arr:Array[Array[T]]) :Array[Array[T]] =
  {
    if(!arr.isEmpty && !arr(0).isEmpty && !arr(0)(0).isInstanceOf[A])
      throw new IllegalArgumentException("type do not match")

    arr.map(_.map(x=>invert(x.asInstanceOf[A]).asInstanceOf[T]))
  }

}
