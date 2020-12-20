package ImageFilter


import java.util

import scala.reflect.ClassTag

class FilterList extends Filter {
  override def filter[T:ClassTag](arr:Array[Array[T]]) :Array[Array[T]] = ???
}
