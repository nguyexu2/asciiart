package ImageFilter.ArrayFilters

import scala.reflect.ClassTag

trait Filter {
  def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]]
}
