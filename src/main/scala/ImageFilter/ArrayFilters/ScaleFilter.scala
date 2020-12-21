package ImageFilter.ArrayFilters

import ImageFilter.Filter

import scala.reflect.ClassTag

class ScaleFilter[A](value:Double, f: Seq[A] => A) extends Filter {
  override def filter[T:ClassTag](arr:Array[Array[T]]) :Array[Array[T]] = ???
}
